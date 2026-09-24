# 3. Executor Framework, Futures, and Real Applications

## The child-friendly picture

Imagine a restaurant receiving 100 orders. Hiring one new cook for every
order would be slow and wasteful. Instead, the restaurant keeps a team of
cooks. Orders wait in a queue, and a free cook takes the next order.

- The **task** is the order.
- A **worker thread** is a cook.
- The **thread pool** is the team of cooks.
- The **ExecutorService** is the manager.
- The **Future** is the receipt saying, "Your result will be ready later."

## Why not create raw threads forever?

Every thread uses memory. Creating too many creates scheduling and context
switching overhead. A thread pool reuses workers, limits concurrency, and
queues extra tasks instead of creating unlimited threads.

```java
ExecutorService pool = Executors.newFixedThreadPool(2);
pool.submit(() -> System.out.println("Work"));
pool.shutdown();
```

With two workers and five tasks, two can run first; the remaining tasks wait
until a worker becomes free.

## Common pools

- `newFixedThreadPool(n)`: at most `n` workers; good when you want a limit.
- `newSingleThreadExecutor()`: one worker; tasks are processed sequentially.
- `newScheduledThreadPool(n)`: delayed and periodic work.
- `newCachedThreadPool()`: creates workers as needed and reuses idle ones;
  use carefully because it can grow quickly.

## Runnable, Callable, and Future

`Runnable` is a job with no returned result:

```java
pool.submit(() -> System.out.println("Saved"));
```

`Callable<T>` is a job that returns a value and can throw an exception:

```java
Future<Integer> result = pool.submit(() -> 10 + 20);
System.out.println(result.get());
```

`Future.get()` waits if necessary. Calling `get()` immediately after every
submission can accidentally make tasks run one by one; submit all independent
tasks first, then collect their results.

`shutdown()` means "accept no new tasks, but finish submitted tasks."
`shutdownNow()` requests interruption and may leave tasks unfinished. Always
shut down executors owned by your application.

## CompletableFuture: a conveyor belt

`CompletableFuture` builds a pipeline where one result flows to the next:

```java
CompletableFuture
        .supplyAsync(() -> "order")
        .thenApply(String::toUpperCase)
        .thenAccept(System.out::println);
```

- `supplyAsync`: start work that returns a value.
- `thenApply`: transform a value.
- `thenAccept`: consume a value without returning one.
- `thenCompose`: start another asynchronous operation using the first result.
- `thenCombine`: combine two independent results.
- `exceptionally`: provide recovery when a stage fails.

The default async methods use the common pool. In production, pass an
explicitly configured executor when you need predictable capacity or want to
isolate workloads.

## Real application example

An online shop might:

1. Receive an order on a request thread.
2. Submit payment validation to a bounded pool.
3. Submit inventory checking to another service.
4. Combine both results.
5. Send confirmation without blocking unrelated requests.

Do not use one giant pool for every kind of work. CPU-heavy work, database
work, and network work have different limits.

## Interview view

**Why use ExecutorService?** It separates task submission from thread
management, reuses workers, and controls concurrency.

**What happens after `submit()`?** A task is queued or assigned to an
available worker; `submit()` returns immediately with a `Future`.

**What if a task throws?** For `submit`, the exception is stored in the
`Future` and is normally observed through `get()` as `ExecutionException`.

**`shutdown()` versus `shutdownNow()`?** The first completes accepted work;
the second requests interruption and returns tasks that never started.

**Why can a pool still be dangerous?** An unbounded queue can consume memory,
and blocking tasks can exhaust all workers. Use bounded resources, timeouts,
monitoring, and proper exception handling.

## Safe production checklist

1. Choose pool size based on CPU or external-service capacity.
2. Submit work that is small and clearly owned.
3. Do not block pool workers unnecessarily.
4. Handle exceptions and cancellation.
5. Use timeouts for network calls and locks.
6. Shut down application-owned executors.
7. Prefer immutable data and minimize shared mutable state.
