# 1. Garbage Collection Fundamentals

## Start with the simple idea

When a Java program creates an object with `new`, the object lives in memory
on the **heap**. A reference is like a note that tells the program where that
object is. As long as the program can still follow some reference to an
object, it may need the object. When the object can no longer be reached by
the running program, it becomes **eligible for garbage collection**.

Think of objects as toys in a room and references as strings tied to them.
If at least one string is still tied to a toy, Java considers that toy
reachable. When all strings are gone, Java is allowed to clean up the toy.
The cleanup does not have to happen immediately.

## What the garbage collector does

Java automatically manages the memory used by objects. A garbage collector
(GC) reclaims heap memory from objects that are no longer reachable, so that
memory can be reused for future allocations.

This helps programmers avoid manually freeing ordinary Java objects, but it
does not mean memory is unlimited. An application can keep objects reachable
by mistake and use more and more memory. That is a **memory leak** in the
practical Java sense: the memory is technically reachable, but the
application no longer needs it.

GC manages Java memory. It does not automatically close files, database
connections, sockets, or other external resources. Close those explicitly,
usually with `try`-with-resources.

## Reachability: the key rule

The JVM starts from a set of special live references called **GC roots** and
follows references from them. An object is reachable if there is a path from
a root to it. An object with no such path is unreachable and eligible for
collection.

Common examples of roots include:

- references held by active thread stacks, such as local variables currently
  in use;
- references from static fields of loaded classes;
- live threads and objects they can reach;
- certain references held by JVM internals or native code.

Example:

```java
Person first = new Person(); // first points to Person object A
Person second = first;       // both references point to object A
first = null;                // second still reaches object A
second = null;               // no local reference reaches object A
```

After the last assignment, object A may become eligible, provided no other
reference elsewhere in the program points to it. Setting one variable to
`null` is not enough if another reference still reaches the same object.

## The six assignment cases

### 1. Make an object eligible

Create an object and remove its last reference, for example by assigning
`null` to the only variable that points to it. The object then becomes
eligible unless some other reference exists.

### 2. Reassign a reference

```java
Person person = new Person(); // object A
person = new Person();        // person now points to object B
```

If there was no other reference to object A, A becomes eligible at the second
assignment. Object B is still reachable through `person`.

### 3. An object goes out of scope

```java
static void makePerson() {
    Person person = new Person();
}
```

When the method returns, its local variable is no longer available to the
caller. If the method did not return the object, store it elsewhere, or pass
it to something that retains it, the object is no longer reachable from that
local and can become eligible. Scope ending does not itself force collection.

### 4. `System.gc()`

`System.gc()` asks the JVM to make a best-effort attempt to run garbage
collection. It is only a **request**. The JVM may ignore it, delay collection,
or decide collection is unnecessary. Even when GC runs, there is no promise
that a particular eligible object is collected at that exact moment.

Programs should never depend on `System.gc()` for correctness or timely
cleanup.

### 5. One reference is set to null

```java
String a = new String("Java");
String b = new String("Spring");
a = null;
```

The `String` object created by `new String("Java")` is eligible if no other
reference points to it. The object created by `new String("Spring")` is
still reachable through `b`. The string literals may also be retained by the
string pool; that does not make the separate object created with `new`
reachable.

### 6. Two references are set to null

```java
String a = new String("Java");
String b = new String("Spring");
String c = new String("Boot");
a = null;
b = null;
```

The separate `String` objects created for `a` and `b` are eligible if there
are no other references to them. The object created for `c` is still
reachable through `c`. Again, a literal in the string pool is separate from
the `new String(...)` object.

## Eligible does not mean collected

These are two different statements:

- **Eligible:** no strong path from a GC root reaches the object.
- **Collected:** a garbage-collection cycle has actually reclaimed its
  memory.

An eligible object may remain in memory for some time. Collection timing and
which eligible object is reclaimed are controlled by the JVM. Java gives no
general guarantee that a GC request runs immediately.

Do not try to prove collection by printing from a `finalize()` method.
Finalization is deprecated for removal, unpredictable, and not a safe
resource-management mechanism.

## A simplified picture of collection

The exact collector and algorithms depend on the JVM and its settings, but a
useful high-level model is:

1. The JVM identifies roots.
2. It follows references and identifies reachable objects.
3. Objects not found reachable can have their memory reclaimed.
4. Some collectors may move or compact surviving objects to reduce
   fragmentation.

Many JVMs organize heap memory and collect short-lived objects differently
from long-lived ones. That is an implementation strategy, not a promise that
every JVM has the same generations, regions, or collection schedule.

## Avoiding accidental memory leaks

An object can be unreachable even if a variable once referred to it. More
commonly, a leak happens because an object remains reachable unintentionally:

- a static collection keeps old entries forever;
- a cache has no size limit or expiration policy;
- a listener is registered but never removed;
- a long-lived object retains a large object graph;
- a `ThreadLocal` value remains attached to a reused thread.

Remove entries and listeners when they are no longer needed, and design
caches with deliberate eviction rules.

## Important interview points

- Java automatically reclaims memory for unreachable heap objects.
- Reachability from GC roots—not whether a variable is in a particular
  source-code line—is the core eligibility rule.
- Reassigning the only reference can make the old object eligible.
- A method-local object can become eligible after the method returns if it
  did not escape and no other references remain.
- `System.gc()` is a request, not a guarantee.
- Eligible objects are not necessarily collected immediately.
- GC does not replace closing files, sockets, or database resources.
- A Java memory leak often means the program still holds references to
  objects it no longer needs.
