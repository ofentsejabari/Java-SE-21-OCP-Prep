package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Documents the Java Collections Framework hierarchy for the Java SE 21 OCP exam.
 *
 * <h2>Two root types</h2>
 * <ul>
 *   <li>{@link Collection} — a group of elements ({@code List}, {@code Set}, {@code Queue}).
 *       Extends {@link Iterable}, so you can use a for-each loop.</li>
 *   <li>{@link java.util.Map} — key/value pairs. Does <i>not</i> extend {@code Collection}.</li>
 * </ul>
 *
 * <h2>Collection sub-interfaces</h2>
 * <pre>
 * Iterable
 *   Collection
 *     List                 — ordered, indexed, duplicates allowed
 *     Set                  — unique elements
 *       SortedSet
 *         NavigableSet
 *     Queue                — typically FIFO
 *       Deque              — double-ended (FIFO and LIFO)
 *     SequencedCollection  — Java 21; first/last access (List and Deque implement it)
 * </pre>
 *
 * <h2>Map sub-interfaces</h2>
 * <pre>
 * Map
 *   SortedMap
 *     NavigableMap
 *   SequencedMap           — Java 21
 * </pre>
 *
 * <h2>Implementations to know for the exam</h2>
 * <ul>
 *   <li>List: {@code ArrayList} (array-backed, O(1) random access),
 *       {@code LinkedList} (nodes; also a {@code Deque}).</li>
 *   <li>Set: {@code HashSet} (unordered), {@code LinkedHashSet} (insertion order),
 *       {@code TreeSet} (sorted).</li>
 *   <li>Queue: {@code ArrayDeque} (preferred deque/stack),
 *       {@code PriorityQueue} (heap ordered by priority).</li>
 *   <li>Map: {@code HashMap} (unordered), {@code LinkedHashMap} (insertion order),
 *       {@code TreeMap} (sorted keys).</li>
 * </ul>
 *
 * <h2>Common {@code Collection} methods</h2>
 * <ul>
 *   <li>{@code add} / {@code addAll} — insert; {@code add} returns {@code false} if the
 *       collection refused the element (typical for a {@code Set} that already contains it).</li>
 *   <li>{@code remove} / {@code removeAll} / {@code retainAll} / {@code removeIf}.</li>
 *   <li>{@code contains} / {@code containsAll} / {@code size} / {@code isEmpty} / {@code clear}.</li>
 *   <li>{@code iterator()} / {@code toArray()} / {@code stream()}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Collections store <i>objects</i>, not primitives — autoboxing converts
 *       {@code int} to {@code Integer}.</li>
 *   <li>Declare the interface, instantiate the class:
 *       {@code List<String> names = new ArrayList<>();}</li>
 *   <li>{@code Map} has no {@code add} or collection-level iterator; walk
 *       {@code keySet()}, {@code values()}, or {@code entrySet()}.</li>
 *   <li>{@code Vector}, {@code Hashtable} and {@code Stack} are legacy synchronized
 *       types. Prefer {@code ArrayList}, {@code HashMap} and {@code ArrayDeque}.</li>
 * </ul>
 */
public class CollectionHierarchy {

    public static void main(String[] args) {
        Collection<String> listAsCollection = new ArrayList<>();
        listAsCollection.add("Java");
        listAsCollection.add("Java");          // List allows duplicates
        listAsCollection.add("OCP");
        System.out.println(listAsCollection);  // [Java, Java, OCP]
        System.out.println(listAsCollection.size());     // 3
        System.out.println(listAsCollection.contains("OCP")); // true

        Collection<String> setAsCollection = new HashSet<>();
        setAsCollection.add("Java");
        setAsCollection.add("Java");          // Set rejects the duplicate
        setAsCollection.add("OCP");
        System.out.println(setAsCollection);  // [Java, OCP]  (order not guaranteed)
        System.out.println(setAsCollection.add("OCP"));   // false — already present

        listAsCollection.removeIf(s -> s.equals("Java"));
        System.out.println(listAsCollection); // [OCP]

        List<String> names = new ArrayList<>(List.of("Ann", "Bob", "Cara"));
        names.addAll(List.of("Dan", "Eve"));
        names.removeAll(List.of("Bob", "Eve"));
        names.retainAll(List.of("Ann", "Dan"));
        System.out.println(names);            // [Ann, Dan]

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Set<Integer> boxed = new HashSet<>();
        boxed.add(1);                         // autobox int -> Integer
        boxed.add(Integer.valueOf(2));
        System.out.println(boxed);            // [1, 2]  (order not guaranteed)
    }
}
