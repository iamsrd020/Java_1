# Garbage Collection Assignments

These examples demonstrate **eligibility**, not the exact time an object is
collected. Java does not guarantee when collection occurs.

| Class | Topic |
|---|---|
| `Assignment01EligibleForGc` | Remove the only reference to an object |
| `Assignment02ReassignReference` | Reassign a reference and identify the old object |
| `Assignment03ObjectOutOfScope` | Create an object in a method that returns |
| `Assignment04RequestGc` | Make an object eligible and request GC |
| `Assignment05IdentifyEligibleObject` | Explain which of two string objects is eligible |
| `Assignment06FindEligibleObjects` | Explain which objects are eligible and reachable |

Compile from the project root:

```text
javac -encoding UTF-8 -d out src/garbagecollection/assignments/*.java
```

Run a class, for example:

```text
java -cp out garbagecollection.assignments.Assignment04RequestGc
```

The message from `System.gc()` only reports that a request was made. It does
not prove that garbage collection ran.
