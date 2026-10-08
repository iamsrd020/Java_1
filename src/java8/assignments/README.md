# Java 8 Assignments

Each assignment is a separate runnable class in the `java8.assignments`
package.

| Class | Topic |
|---|---|
| `Assignment01LambdaMultiplication` | Lambda multiplication |
| `Assignment02StreamFilterNumbers` | Filter numbers greater than 30 |
| `Assignment03StreamSquareNumbers` | Square values with `map()` |
| `Assignment04StreamSalaryCount` | Count salaries over 50,000 |
| `Assignment05OptionalPresent` | Print a present `Optional` value |
| `Assignment06OptionalDefault` | Use `"Unknown"` for an empty `Optional` |
| `Assignment07VehicleDefaultMethod` | Inherit an interface default method |
| `Assignment08OverrideDefaultMethod` | Override an interface default method |
| `Assignment09LocalDate` | Print today's date |
| `Assignment10LocalTime` | Print the current time |
| `Assignment11LocalDateTime` | Print current date and time |
| `Assignment12PeriodBetweenDates` | Find a date-based period |
| `Assignment13EmployeeNameStreams` | Process employee names using streams |
| `Assignment14EmployeeManagement` | Combine Java 8 features in one program |

Compile from the project root:

```text
javac -encoding UTF-8 -d out src/java8/assignments/*.java
```

Run a class, for example:

```text
java -cp out java8.assignments.Assignment14EmployeeManagement
```
