# Collections Assignments

This folder contains the assignments shared by our instructor. It is kept
separate from the collection reference examples in the parent `collections`
folder.

## Folder contents

```text
assignments/
|-- CollectionsAssignments.java  # Runs every assignment
|-- ListAssignment.java          # List of three names
|-- SetAssignments.java          # HashSet, LinkedHashSet, TreeSet
|-- MapAssignments.java          # HashMap, LinkedHashMap, TreeMap
|-- QueueAssignments.java        # PriorityQueue and task Queue
`-- README.md
```

## What each assignment demonstrates

### List

Creates an `ArrayList<String>`, adds three names, and prints them.

### HashSet

Stores student names. The duplicate name is ignored because a Set stores only
unique values. The display order is not guaranteed.

### LinkedHashSet

Stores employee names without duplicates while preserving insertion order.

### TreeSet

Stores numbers without duplicates and automatically sorts them in ascending
order.

### HashMap

Stores student IDs and names. It demonstrates lookup, updating an existing
key, removing an entry, and checking whether a key exists.

### LinkedHashMap

Stores employee IDs and names while preserving insertion order. Updating an
existing ID changes its value instead of creating another key.

### TreeMap

Stores product IDs and names and automatically sorts entries by product ID.

### PriorityQueue

Processes numbers by priority. With the default configuration, the smallest
number is removed first.

### Task Queue

Processes tasks in FIFO order: First In, First Out.

## How to run

Run this class to execute every assignment:

```text
collections.assignments.CollectionsAssignments
```

For focused practice, run one of these classes:

```text
collections.assignments.ListAssignment
collections.assignments.SetAssignments
collections.assignments.MapAssignments
collections.assignments.QueueAssignments
```
