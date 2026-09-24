# Multithreading Assignments

This folder contains the multithreading, `ExecutorService`, and deadlock
assignments in one runnable class:

```text
multithreading/
`-- assignments/
    |-- MultithreadingAssignments.java
    `-- README.md
```

Run `multithreading.assignments.MultithreadingAssignments` to execute all
examples. The order of output from different threads can change between runs;
that is normal because the JVM scheduler decides which ready thread runs next.

## What multithreading means

A **thread** is a path of execution inside a program. The `main` method runs
on the main thread. Multithreading means allowing multiple paths of execution
to make progress in the same process. For example, one thread can process an
order while another thread monitors a file.

Threads share the same heap memory. This makes communication easy, but it also
creates problems when two threads access the same mutable data:

- **Race condition:** the result depends on timing.
- **Visibility problem:** one thread may not immediately see another thread's
  update.
- **Deadlock:** threads wait forever for locks held by one another.

## `start()` versus `run()`

`start()` asks the JVM to create a new thread and then invokes `run()` on that
new thread. Calling `run()` directly is only a normal method call on the
current thread; it does not create a new thread.

## Runnable

`Runnable` represents work that can be run. It separates the task from the
thread that executes it and is usually preferred over extending `Thread`.

## Daemon threads

A daemon thread performs background work. The JVM does not keep running only
for daemon threads, so a daemon monitor stops automatically when all
non-daemon threads finish. A daemon should not be used for work that must be
saved or completed.

## Synchronization

` synchronized` allows only one thread at a time to enter a protected method
or block for the same lock. In the bank example, it prevents both customers
from reading and changing the balance at the same time. With ₹1000 and two
withdrawals of ₹700, only one withdrawal succeeds and the final balance is
₹300.

## `volatile`

`volatile` guarantees visibility of a variable between threads. When one
thread changes a volatile flag, another thread reading that flag sees the
latest value. It does **not** make compound operations such as `count++`
atomic; use synchronization or an atomic class for those operations.

## ExecutorService

`ExecutorService` manages a pool of reusable worker threads:

- `newFixedThreadPool(2)` creates at most two worker threads.
- `submit(Runnable)` schedules work with no result.
- `submit(Callable<T>)` schedules work that returns a result.
- `Future<T>` represents a result that may be available later.
- `shutdown()` stops accepting new tasks but lets submitted tasks finish.

A pool of three threads can execute five tasks in waves: three tasks can run
first, and the remaining two run as workers become free. A
`newSingleThreadExecutor()` uses one worker, so submitted tasks execute
sequentially in submission order.

## Deadlock

Deadlock requires a circular wait. In the example:

```text
Thread 1: holds Lock 1 -> waits for Lock 2
Thread 2: holds Lock 2 -> waits for Lock 1
```

Neither thread can continue because each is waiting for the other. The
assignment intentionally creates this state with daemon threads and uses a
timeout so the full demo does not hang. The safest basic prevention is to
make every thread acquire multiple locks in the same global order.

Other options include using `tryLock` with a timeout, reducing nested locks,
and keeping synchronized sections small.

## Assignment map

| Method | Topic |
|---|---|
| `createThread` | Creating a thread |
| `createThreadUsingRunnable` | `Runnable` |
| `createTwoThreads` | Two threads |
| `startVsRun` | `start()` and `run()` |
| `daemonThread` | Daemon thread |
| `synchronizedWithdrawal` | Synchronization |
| `volatileFlag` | `volatile` |
| `basicExecutorService` | Fixed pool and `shutdown()` |
| `multipleTasks` | Five tasks on three threads |
| `executorWithRunnable` | Reusing a `Runnable` |
| `executorWithCallable` | `Callable` and `Future` |
| `fixedThreadPool` | Five tasks on two threads |
| `singleThreadExecutor` | Sequential execution |
| `callableTaskResults` | Three callable results |
| `createDeadlock` | Creating a deadlock |
| `avoidDeadlock` | Consistent lock order |
| `identifyDeadlock` | Explaining deadlock |
