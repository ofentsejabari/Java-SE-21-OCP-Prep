# Java Collections APIs (Java SE 21 OCP)

The Java Collections Framework lives in `java.util`. A **`Collection`** is a group of elements; a **`Map`** is a separate key/value API and does **not** extend `Collection`.

Declare the interface and instantiate the class:

```java
List<String> names = new ArrayList<>();
Set<String> unique = new HashSet<>();
Map<String, Integer> scores = new HashMap<>();
```

Collections store **objects**, not primitives. Autoboxing converts `int` to `Integer`.

---

## Hierarchy (know this for the exam)

```
Iterable
  Collection
    List                    — ordered, indexed, duplicates allowed
    Set                     — unique elements
      SortedSet
        NavigableSet
    Queue                   — typically FIFO
      Deque                 — double-ended (FIFO and LIFO)
    SequencedCollection     — Java 21; first/last access (List and Deque)

Map                         — does NOT extend Collection
  SortedMap
    NavigableMap
  SequencedMap              — Java 21
```

| Interface | Meaning | Typical implementations |
|---|---|---|
| `List` | Ordered, indexed, duplicates OK | `ArrayList`, `LinkedList` |
| `Set` | Unique elements | `HashSet`, `LinkedHashSet`, `TreeSet` |
| `Queue` / `Deque` | FIFO, or both ends (stack + queue) | `ArrayDeque`, `PriorityQueue`, `LinkedList` |
| `Map` | Unique keys → values | `HashMap`, `LinkedHashMap`, `TreeMap` |
| `SequencedCollection` / `SequencedSet` / `SequencedMap` | Java 21 first/last + `reversed()` | `List`, `ArrayDeque`, `LinkedHashSet`, `LinkedHashMap`, `TreeSet`, `TreeMap` |

**Order rules**

- `HashSet` / `HashMap` — no guaranteed order
- `LinkedHashSet` / `LinkedHashMap` — insertion order
- `TreeSet` / `TreeMap` — sorted (natural order or a `Comparator`)

**Legacy types to recognise, not to prefer:** `Vector`, `Hashtable`, `Stack` (synchronized). Use `ArrayList`, `HashMap`, and `ArrayDeque` instead.

---

## Files to run

Each class has a `main` method. Read the Javadoc at the top of the file, then run it.

| File | What it covers |
|---|---|
| `CollectionHierarchy` | Two root types (`Collection` vs `Map`); common methods (`add`, `removeIf`, `retainAll`); autoboxing |
| `ListExample` | `ArrayList` vs `LinkedList`; `List.of` (immutable) vs `Arrays.asList` (fixed-size); `subList` view; `remove(int)` vs `remove(Object)` |
| `ConversionBetweenListArray` | `List` ↔ array: `toArray` / `toArray(T[])` / `String[]::new`; `Arrays.asList` view vs `List.of` copy; primitive-array trap |
| `SetExample` | Uniqueness; insertion order vs sorted order; `Set.of`; `null` rules |
| `QueueExample` | `offer` / `poll` / `peek` vs `add` / `remove` / `element`; `ArrayDeque` as stack; `PriorityQueue` |
| `MapExample` | `put` / `getOrDefault` / `merge` / `computeIfAbsent`; iterating `entrySet`; `Map.of` |
| `SortingArrayList` | `Collections.sort` / `List.sort` on `ArrayList`; reverse order; `List.of` vs `Arrays.asList`; `ClassCastException` |
| `SortingCollections` | `Comparable` vs `Comparator`; `List.sort`; `Collections.binarySearch` |
| `SequencedCollections` | Java 21 `getFirst` / `addLast` / `reversed()` views |

---

## Exam traps to memorise

1. **Objects only.** Collections cannot store primitives. `list.add(1)` autoboxes to `Integer`.
2. **`List.of` / `Set.of` / `Map.of`** are immutable and reject `null` (`NullPointerException`). `add` / `put` throw `UnsupportedOperationException`. `Set.of` and `Map.of` also reject duplicate keys/elements (`IllegalArgumentException`).
3. **`Arrays.asList(...)`** is a **fixed-size** view of an array. `set` works; `add` / `remove` throw. Changes affect the backing array.
4. **`HashSet` / `HashMap` have no guaranteed order.** Never assume iteration order unless the type is `LinkedHash*` or `Tree*`.
5. **`ArrayDeque` and `PriorityQueue` reject `null`** (`NullPointerException`). `LinkedList` as a queue allows `null`, which makes `poll()` / `peek()` returning `null` ambiguous.
6. **`Map` is not a `Collection` and is not `Iterable`.** Walk `entrySet()`, `keySet()`, or `values()`. There is no `map.add(...)`.
7. **`List<Integer>` remove trap.** `remove(1)` calls `remove(int index)`, not `remove(Object)`. Use `remove(Integer.valueOf(1))` to remove the value `1`.
8. **Queue two families.** `add` / `remove` / `element` **throw** on failure (`IllegalStateException` / `NoSuchElementException`). `offer` / `poll` / `peek` return `false` or `null`.
9. **`PriorityQueue` iteration is not sorted.** Only `peek` / `poll` honour priority (smallest / comparator-least first).
10. **`get` returning `null` on a `Map` is ambiguous** — missing key *or* a stored `null` value. Prefer `containsKey` or `getOrDefault`.
11. **`TreeSet` / `TreeMap` use `compareTo`, not `equals`,** for uniqueness/order. They reject `null` keys/elements. A type that is not `Comparable` needs a `Comparator` or you get `ClassCastException`.
12. **`Collections.binarySearch` (and `Arrays.binarySearch`) require a sorted list** in the *same* order used for the search. Missing key returns `-(insertionPoint) - 1`.
13. **Java 21 sequenced APIs.** `HashSet` and `HashMap` are *not* sequenced. `getFirst` / `getLast` on an empty sequenced collection throw `NoSuchElementException`. `reversed()` is a **live view**, not a copy.
14. **Do not modify a collection while iterating it** with an enhanced-for loop — `ConcurrentModificationException`. Use `Iterator.remove()` or `removeIf`.
15. **`Map.of` allows at most 10 key/value pairs.** Use `Map.ofEntries(Map.entry(k, v), ...)` for more.
16. **`list.toArray()` returns `Object[]`.** Casting it to `String[]` throws `ClassCastException`. Use `list.toArray(new String[0])` or `list.toArray(String[]::new)`.
17. **`Arrays.asList(new int[]{1, 2})` is a `List<int[]>` of one element.** Varargs do not unbox primitives. Use `Integer[]` or `List.of(1, 2)`. `List.of(array)` copies; `Arrays.asList(array)` is a live view.

---

## Quick method cheat sheet

**Collection:** `add`, `addAll`, `remove`, `removeAll`, `retainAll`, `removeIf`, `contains`, `size`, `isEmpty`, `clear`, `iterator`, `toArray`, `stream`

**List:** `get`, `set`, `add(index, e)`, `remove(index)`, `indexOf`, `lastIndexOf`, `subList`  
Java 21: `getFirst`, `getLast`, `addFirst`, `addLast`, `removeFirst`, `removeLast`, `reversed`

**Set:** uniqueness via `equals` / `hashCode` (hash-based) or `compareTo` (`TreeSet`)

**Queue / Deque:** `offer` / `poll` / `peek` (safe); `push` / `pop` (stack on `Deque`)

**Map:** `put`, `get`, `getOrDefault`, `putIfAbsent`, `merge`, `computeIfAbsent`, `containsKey`, `keySet`, `values`, `entrySet`
