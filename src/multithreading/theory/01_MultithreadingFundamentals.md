# 1. Multithreading Fundamentals

## First, the child-friendly picture

Think of your computer as a school.

- A **process** is one classroom with its own books, desks, and supplies.
- A **thread** is one child doing one activity in that classroom.
- Several children in the same classroom can use shared supplies.
- If two children grab the same pencil and change it at the same time, there
  is a problem. That is why shared data needs rules.

Java starts one thread automatically: the **main thread**. Multithreading
means adding more workers so different jobs can make progress together.

## Process versus thread

A process is a running program with its own operating-system resources. A
thread is a path of execution inside a process. Threads in one process share
heap objects, but each thread has its own stack, local variables, and current
instruction.

Sharing memory is fast because threads do not need to send every value through
another process. It is also dangerous because shared mutable objects can be
changed by different threads.

## Concurrency versus parallelism

**Concurrency** means several tasks are in progress during overlapping time.
One worker may run a little, pause, and let another worker run.

**Parallelism** means two tasks are literally running at the same moment on
different CPU cores. Concurrency can happen on one core; parallelism needs
multiple cores.

Real examples:

- A web server handles one request while another request waits for a database.
- A music app downloads a song while the user scrolls.
- An online shop processes many orders at the same time.

## Creating a thread

The `Thread` object is the worker. A `Runnable` is the job:

```java
Runnable job = () -> System.out.println("Work");
Thread worker = new Thread(job);
worker.start();
worker.join();
```

`Runnable` is usually preferred because it describes work separately from the
worker and does not use up Java's single class inheritance slot. Extend
`Thread` only when you genuinely need to customize a thread object.

## `start()` versus `run()`

This is an important interview question:

```java
thread.start(); // JVM schedules a new thread
thread.run();   // ordinary method call on the current thread
```

Calling `run()` directly does not create a new thread. If you call it from
`main`, the main thread performs the work. A thread can be started only once;
calling `start()` a second time throws `IllegalThreadStateException`.

## Thread lifecycle

Imagine a child moving through school:

1. **NEW:** the child exists but has not started the activity.
2. **RUNNABLE:** the child is ready or currently running. Java groups both
   ideas into this state.
3. **BLOCKED:** the child wants a room protected by a lock, but another child
   is inside.
4. **WAITING:** the child waits until another thread explicitly wakes or
   finishes, such as `join()`.
5. **TIMED_WAITING:** the child waits for a limited time, such as `sleep(1000)`.
6. **TERMINATED:** the work finished or failed with an uncaught exception.

The actual Java enum is `Thread.State`. A thread does not move backward from
`TERMINATED`.

## Important methods

- `start()`: begins a new thread.
- `run()`: contains the work; direct calling is not multithreading.
- `sleep(milliseconds)`: pauses the current thread. It does not release a
  synchronized lock.
- `join()`: waits for another thread to finish.
- `interrupt()`: sends a polite stop/wakeup request. It does not forcibly kill
  a thread. Good code checks interruption and exits safely.

## Daemon threads

A daemon thread is a background helper, like a security camera in a shop.
When all normal (non-daemon) work finishes, the JVM may exit without waiting
for daemon work. Therefore a daemon is suitable for monitoring or cleanup,
but not for saving a bank transaction or writing an important file.

## Interview questions

**Why use threads?** To keep applications responsive, overlap waiting work,
handle many requests, or use CPU cores.

**Is creating more threads always faster?** No. Threads consume memory and
context switching costs time. Too many threads can make an application slower.

**What does `join()` do?** It makes the calling thread wait until the target
thread finishes.

**What is the difference between `sleep()` and `wait()`?** `sleep()` belongs
to `Thread` and keeps monitors; `wait()` belongs to `Object`, releases the
monitor, and must be used while owning that monitor.
