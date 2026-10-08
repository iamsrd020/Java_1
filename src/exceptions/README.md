# Exception Handling in Java

This folder separates the concepts from the runnable practice, following the
same structure as `multithreading`:

```text
exceptions/
|-- assignments/
|   |-- Assignment01TryCatchDivision.java
|   |-- Assignment02ArrayIndexOutOfBounds.java
|   |-- Assignment03ThrowAgeCheck.java
|   |-- Assignment04CustomException.java
|   |-- Assignment05FinallyBlock.java
|   |-- BankAccount.java
|   |-- InsufficientBalanceException.java
|   `-- README.md
|-- theory/
|   `-- 01_ExceptionHandlingFundamentals.md
`-- README.md
```

## Learning path

1. Read `theory/01_ExceptionHandlingFundamentals.md` to understand exceptions,
   `try`/`catch`, `throw`, custom exceptions, and `finally`.
2. Run the matching examples listed in `assignments/README.md`.

## The basic idea

```text
EXCEPTION HANDLING
├── try       -> code that may fail
├── catch     -> respond to a particular exception
├── throw     -> raise an exception yourself
├── throws    -> declare an exception a method may pass to its caller
├── finally   -> cleanup code that should run after try/catch
└── custom exception -> describe an application-specific problem
```

Exceptions let a program respond to unexpected situations instead of stopping
without a useful explanation. Catch only the exceptions you can handle, and
let other failures remain visible to the caller.
