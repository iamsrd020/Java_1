# Exception Handling Assignments

Each assignment is a separate runnable Java class in the
`exceptions.assignments` package.

| Class | Topic |
|---|---|
| `Assignment01TryCatchDivision` | Catch division by zero |
| `Assignment02ArrayIndexOutOfBounds` | Handle an invalid array index |
| `Assignment03ThrowAgeCheck` | Throw an `IllegalArgumentException` for an age below 18 |
| `Assignment04CustomException` | Handle a custom insufficient-balance exception |
| `Assignment05FinallyBlock` | Demonstrate that `finally` runs after an exception |

`BankAccount` and `InsufficientBalanceException` support the custom exception
assignment.

Run any class from IntelliJ IDEA, or compile the package from the project root:

```text
javac -encoding UTF-8 -d out src/exceptions/assignments/*.java
```

Then run an assignment, for example:

```text
java -cp out exceptions.assignments.Assignment04CustomException
```
