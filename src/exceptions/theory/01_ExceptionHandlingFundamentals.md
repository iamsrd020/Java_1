# 1. Exception Handling Fundamentals

## The child-friendly picture

Imagine following a recipe. If the shop has run out of an ingredient, you
cannot finish that step as written. You need to handle the problem: use a
replacement, tell someone, or stop with a clear message.

An **exception** is Java's way of reporting that something unexpected
happened while a program was running. Exception handling lets the program
respond or pass the problem to code that knows how to respond.

## The exception family

Java represents problems using objects. The main family looks like this:

```text
Throwable
├── Error                  serious JVM or environment problem
└── Exception
    ├── checked exceptions     compiler requires handling or declaration
    └── RuntimeException       unchecked programming or input problems
```

- **Checked exceptions**, such as `IOException`, must be caught or declared
  with `throws`. They often describe conditions an application may be able
  to recover from.
- **Unchecked exceptions** are `RuntimeException` and its subclasses. The
  compiler does not require handling them. Examples include
  `IllegalArgumentException`, `ArithmeticException`, and
  `ArrayIndexOutOfBoundsException`.
- **Errors** generally indicate serious problems that ordinary application
  code should not try to handle.

## `try` and `catch`

Put code that may throw an exception inside `try`. A matching `catch` block
handles that exception:

```java
try {
    int result = 10 / 0;
    System.out.println(result);
} catch (ArithmeticException exception) {
    System.out.println("Cannot divide by zero.");
}
```

When the division fails, Java skips the rest of the `try` block and looks
for a matching `catch`. The program continues after the catch block. Catch
the specific exception you expect rather than catching `Exception` for
everything; broad catches can hide programming mistakes.

An exception can be caught only if it is thrown while execution is in the
matching `try` block (or a method called from that block). If no matching
handler exists, the exception propagates up the call stack. If it reaches
the top of the thread without being handled, Java prints a stack trace and
ends that thread.

## Throwing an exception with `throw`

Use `throw` when code detects an invalid condition and cannot continue
normally:

```java
static void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be at least 18.");
    }
    System.out.println("Valid age");
}
```

`throw` raises one exception object. Choose an exception that clearly
describes what is wrong. `IllegalArgumentException` is commonly used when a
method receives an invalid argument.

## Declaring exceptions with `throws`

`throws` appears in a method declaration. It tells callers that a checked
exception may leave that method:

```java
static void readFile() throws IOException {
    // File-reading code may throw IOException.
}
```

The caller must then catch the checked exception or declare it too.
`throw` and `throws` are related but different: `throw` raises an exception;
`throws` declares a possibility in a method signature.

## Custom checked exceptions

Create a custom exception when an application needs a meaningful problem
type of its own. Extending `Exception` makes it checked:

```java
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
```

A method that may raise it declares `throws`, and the caller handles it:

```java
void withdraw(int amount) throws InsufficientBalanceException {
    if (amount > balance) {
        throw new InsufficientBalanceException("Insufficient balance.");
    }
}
```

Extend `RuntimeException` instead when the application wants the custom
exception to be unchecked. Choose based on whether callers should be forced
by the compiler to handle or declare the condition.

## The `finally` block

`finally` runs after the `try` block and any matching `catch` block, whether
the operation succeeded or an exception was handled:

```java
try {
    System.out.println(numbers[5]);
} catch (ArrayIndexOutOfBoundsException exception) {
    System.out.println("Invalid array index.");
} finally {
    System.out.println("Cleanup or final message.");
}
```

Use `finally` for cleanup that must happen, such as releasing a resource.
For resources implementing `AutoCloseable` (for example, files), prefer
**try-with-resources**; Java closes them automatically:

```java
try (BufferedReader reader = Files.newBufferedReader(path)) {
    System.out.println(reader.readLine());
}
```

`finally` is not an absolute guarantee if the JVM exits abruptly or the
process is terminated.

## Common mistakes and good habits

- Catch a specific exception and handle it meaningfully.
- Do not use exceptions to control ordinary program flow.
- Do not leave a catch block empty or print a vague message that hides the
  cause.
- Preserve the original exception when translating it into a higher-level
  error by passing it as the cause.
- Validate arguments at the method boundary and report invalid values
  clearly.
- Use try-with-resources for files, streams, and other `AutoCloseable`
  resources.

## Assignment map

| Assignment | Concepts |
|---|---|
| `Assignment01TryCatchDivision` | `try`/`catch`, `ArithmeticException` |
| `Assignment02ArrayIndexOutOfBounds` | Catching an unchecked exception |
| `Assignment03ThrowAgeCheck` | `throw`, `IllegalArgumentException` |
| `Assignment04CustomException` | A custom checked exception and `throws` |
| `Assignment05FinallyBlock` | `finally` after an exception is handled |
