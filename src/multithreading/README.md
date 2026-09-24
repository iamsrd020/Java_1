# Multithreading in Java: Start Here

Imagine a restaurant. The **process** is the whole restaurant. A **thread** is
one worker inside it. One worker can take an order while another cooks and a
third cleans. They work in the same restaurant, so they can see shared things,
but they must not all change the same thing at the same time.

Start with the theory files, then open the matching assignment:

1. `theory/01_MultithreadingFundamentals.md`
2. `theory/02_SharingDataAndSynchronization.md`
3. `theory/03_ExecutorFramework.md`
4. `assignments/README.md`

## The complete mental model

```text
MULTITHREADING
├── PROCESS: a running program with its own memory
└── THREAD: a path of execution inside a process
    ├── create with Thread or Runnable
    ├── start()
    ├── lifecycle: NEW -> RUNNABLE -> WAITING/BLOCKED -> TERMINATED
    ├── shared data -> race condition
    ├── solve with synchronized, volatile, or atomic classes
    ├── locks -> possible deadlock
    └── real applications -> ExecutorService -> pools -> Future/CompletableFuture
```

Thread output order is not guaranteed. The JVM and operating system scheduler
decide which ready thread runs first.

## The learning path

1. Learn what a process and thread are.
2. Learn how to create a thread with `Thread` or `Runnable`.
3. Learn why `start()` is different from `run()`.
4. Learn the lifecycle: a thread is created, becomes ready, may wait, and
   eventually finishes.
5. Learn that threads share heap data and can therefore create race conditions.
6. Learn the tools: `synchronized` for one-at-a-time work, `volatile` for
   visibility, and atomic classes for small atomic updates.
7. Learn locks and why taking locks in the wrong order causes deadlock.
8. Learn why real applications normally use `ExecutorService` instead of
   creating unlimited raw threads.

## Interview snapshot

- A process has its own memory; threads in one process share heap memory.
- `start()` creates/schedules a new thread; `run()` alone does not.
- `sleep()` pauses but does not release a monitor lock.
- `join()` makes one thread wait for another to finish.
- `synchronized` gives mutual exclusion and visibility.
- `volatile` gives visibility, not compound-operation atomicity.
- `count++` is not thread-safe.
- A thread pool limits and reuses worker threads.
- `Runnable` has no result; `Callable` returns a result through `Future`.
- Deadlock is circular waiting; consistent lock ordering is a common fix.
