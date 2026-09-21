# Java Collections Framework

This folder contains the complete Collections Framework examples in one place.

## Folder structure

```text
collections/
|-- CollectionsDemo.java       # Runs every category
|-- list/
|   `-- ListDemo.java          # ArrayList, LinkedList, Vector, Stack
|-- set/
|   `-- SetDemo.java           # HashSet, LinkedHashSet, TreeSet
|-- queue/
|   `-- QueueDemo.java         # PriorityQueue, ArrayDeque, queue/deque usage
`-- map/
    `-- MapDemo.java           # HashMap, LinkedHashMap, TreeMap
```

## Collection hierarchy

```text
Collection
|-- List
|   |-- ArrayList
|   |-- LinkedList
|   |-- Vector
|   `-- Stack
|-- Set
|   |-- HashSet
|   |-- LinkedHashSet
|   `-- TreeSet
`-- Queue
    |-- PriorityQueue
    |-- ArrayDeque
    `-- LinkedList

Map is separate from Collection:
|-- HashMap
|-- LinkedHashMap
`-- TreeMap
```

## Quick selection guide

| Requirement | Recommended collection |
|---|---|
| Fast index-based list access | `ArrayList` |
| Unique values without ordering | `HashSet` |
| Unique values in insertion order | `LinkedHashSet` |
| Unique sorted values | `TreeSet` |
| Normal queue or modern stack | `ArrayDeque` |
| Priority-based processing | `PriorityQueue` |
| Fast key-value lookup | `HashMap` |
| Key-value lookup with insertion order | `LinkedHashMap` |
| Key-value pairs sorted by key | `TreeMap` |

## Important interview points

- `List` allows duplicates and maintains insertion order.
- `Set` does not allow duplicate elements.
- `Map` stores unique keys and is separate from `Collection`.
- `HashSet` and `HashMap` depend on `hashCode()` and `equals()`.
- `TreeSet` and `TreeMap` use natural ordering or a `Comparator`.
- `PriorityQueue` guarantees priority for its head, not sorted iteration.
- `ArrayDeque` is generally preferred over legacy `Stack`.
- Prefer interface references such as `List<String> list = new ArrayList<>();`.

## Running the examples

Run `collections.CollectionsDemo` to see all examples.

You can also run `ListDemo`, `SetDemo`, `QueueDemo`, or `MapDemo` separately
for focused practice.
