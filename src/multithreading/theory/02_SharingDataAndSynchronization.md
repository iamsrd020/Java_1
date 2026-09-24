# 2. Shared Data, Race Conditions, and Safety

## The child-friendly picture

Imagine two children sharing a piggy bank containing ₹1000. Both want to take
₹700.

If both look at the balance at the same time, both may think, "There is
enough." They both take the money, even though there was enough for only one.
The mistake happened because checking and changing the balance were treated as
separate steps.

That mistake is a **race condition**: the answer changes depending on which
thread gets there first.

## Why `balance -= 700` is not one action

The computer usually performs:

1. Read the balance.
2. Subtract 700.
3. Write the new balance.

Two threads can interleave those steps. The same problem appears with
`count++`; it is read, add, and write, not one indivisible operation.

## `synchronized`: one child at a time

`synchronized` puts a one-person sign on a room. For the same lock, only one
thread enters the protected code at a time. It also creates visibility: when a
thread leaves the synchronized area, a later thread entering with the same
lock can see its changes.

```java
public synchronized void withdraw(int amount) {
    if (balance >= amount) {
        balance -= amount;
    }
}
```

The check and the update are together, so the account invariant "balance never
becomes negative" is protected.

Use a synchronized block when the protected area is small:

```java
synchronized (account) {
    account.withdraw(700);
}
```

Keep critical sections short. If a thread holds a lock while making a slow
network call, every other thread waits unnecessarily.

## `volatile`: a notice board

Imagine a teacher changing a notice board from "class running" to "class
finished." `volatile` says every child must look at the real notice board
instead of trusting an old copy:

```java
private volatile boolean running = true;
```

It guarantees visibility and ordering for that variable. It does **not** make
`count++` safe, because the whole read/add/write sequence is still separate.
Use `volatile` for simple flags and state visibility, not multi-step updates.

## Atomic classes: a magic counter button

`AtomicInteger` provides operations such as `incrementAndGet()` as one
atomic step:

```java
AtomicInteger count = new AtomicInteger();
count.incrementAndGet();
```

Use atomic classes for counters, sequence numbers, and compare-and-set state.
Use synchronization or a lock when several fields must change together.

## Locks

The `synchronized` keyword is an implicit lock. `ReentrantLock` is an explicit
lock with extra features:

```java
lock.lock();
try {
    // protected work
} finally {
    lock.unlock();
}
```

The `finally` block is mandatory because an exception must not leave the lock
stuck forever. `tryLock` can wait for a limited time and then give up.

## Deadlock: two children blocking each other

Deadlock is like this:

```text
Child 1 holds pencil A and waits for pencil B.
Child 2 holds pencil B and waits for pencil A.
```

Neither can continue. The four classic deadlock conditions are:

1. Mutual exclusion: a resource has one owner at a time.
2. Hold and wait: a thread holds one resource while requesting another.
3. No preemption: the resource cannot simply be taken away.
4. Circular wait: each thread waits for another in a circle.

Break one condition to prevent deadlock. The easiest practical rule is a
global order: every thread takes Lock A, then Lock B, never the reverse.
Other options are `tryLock` timeouts, fewer nested locks, and short critical
sections.

## Other problems

- **Starvation:** one thread keeps losing access and never gets its turn.
- **Livelock:** threads keep changing behavior to be polite but no work
  completes.
- **Visibility bug:** one thread keeps seeing an old value.
- **Atomicity bug:** another thread observes a half-completed operation.

## Interview view

**Does `synchronized` provide visibility?** Yes, for the same monitor: unlock
and later lock establish a happens-before relationship.

**Does `volatile` provide mutual exclusion?** No. It makes reads and writes
visible, but does not protect a multi-step critical section.

**When use AtomicInteger instead of synchronized?** For simple independent
atomic updates to one value. Use a lock when the operation involves multiple
related values or complex invariants.

**How do you debug deadlock?** Capture a thread dump, inspect threads in
`BLOCKED`, and find the cycle of locks in tools such as VisualVM, JConsole, or
`jstack`.
