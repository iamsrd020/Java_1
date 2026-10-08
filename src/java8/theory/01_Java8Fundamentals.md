# 1. Java 8 Fundamentals

Java 8 added language and library features that make common Java code more
concise. This guide introduces the features used by the assignments.

## Lambda expressions

A lambda is a short way to provide the implementation of a **functional
interface**—an interface with one abstract method:

```java
@FunctionalInterface
interface Multiplier {
    int multiply(int first, int second);
}

Multiplier multiplier = (first, second) -> first * second;
System.out.println(multiplier.multiply(4, 5));
```

The values on the left of `->` are the method parameters; the expression or
block on the right is the method body. Java infers parameter types from the
functional interface in many cases. Lambdas are often used with collections
and the Stream API.

## Stream API

A stream describes a sequence of values to process. It does not store a new
collection; it processes values from a source such as a list. Operations are
commonly divided into:

- **Intermediate operations**, such as `filter()` and `map()`, which describe
  processing and return another stream.
- **Terminal operations**, such as `forEach()`, `count()`, and `collect()`,
  which produce a result or perform an action and trigger the pipeline.

```java
List<Integer> numbers = Arrays.asList(10, 35, 42, 18);
List<Integer> largeNumbers = numbers.stream()
        .filter(number -> number > 30)
        .collect(Collectors.toList());
```

`filter()` keeps values matching a condition. `map()` transforms each value:

```java
List<Integer> squares = numbers.stream()
        .map(number -> number * number)
        .collect(Collectors.toList());
```

Streams are usually consumed once. Prefer clear, side-effect-free operations;
use a loop when it is easier to understand.

## `Optional`

`Optional<T>` represents a value that may or may not be present. It can make
the absence of a result explicit, such as when searching for an employee:

```java
Optional<String> name = Optional.of("Java");
name.ifPresent(System.out::println);

Optional<String> empty = Optional.empty();
String result = empty.orElse("Unknown");
```

Use `Optional.of(value)` for a known non-null value,
`Optional.ofNullable(value)` when a value may be null, and
`Optional.empty()` when there is no value. `orElse(default)` returns the
contained value or a default. Avoid calling `get()` without first checking
presence. `Optional` is most commonly used for return values, not as a
replacement for every nullable field or method parameter.

## Interface default methods

A default method has an implementation inside an interface. It lets an
interface add behavior while remaining compatible with existing
implementations:

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle started");
    }
}

class Car implements Vehicle {
}
```

`Car` inherits `start()` and can call it. A class may override the default
method when it needs different behavior. If a class inherits conflicting
defaults with the same signature from two interfaces, it must resolve the
conflict explicitly.

## Date and Time API

The `java.time` API provides immutable, clearer date/time types:

- `LocalDate`: calendar date, without a time or time zone.
- `LocalTime`: time of day, without a date or time zone.
- `LocalDateTime`: date and time, still without a time zone.
- `Period`: date-based difference in years, months, and days.

```java
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();

Period difference = Period.between(
        LocalDate.of(2024, 1, 1),
        LocalDate.of(2024, 3, 15));
```

Use `ZonedDateTime` or `OffsetDateTime` when time-zone or UTC-offset
information matters. `LocalDateTime` by itself does not identify a unique
instant worldwide.

## Putting features together

The employee-management assignment uses:

1. A lambda to calculate salary plus bonus.
2. A stream filter to find salaries above a threshold.
3. `Optional` to represent a search that may not find an employee.
4. A default interface method to display shared company information.
5. `LocalDate` to represent each employee's joining date.

These features complement one another: interfaces describe behavior, lambdas
provide small behavior implementations, streams process collections,
`Optional` represents possibly missing results, and `java.time` models dates.
