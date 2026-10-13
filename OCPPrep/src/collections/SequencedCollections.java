package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

/**
 * Documents Java 21 <b>sequenced collections</b> for the OCP exam.
 *
 * <h2>Why they exist</h2>
 * <p>Before Java 21, "first and last element" APIs were scattered:
 * {@code List.get(0)}, {@code Deque.getFirst()}, {@code LinkedHashMap}
 * had no standard way to read the first entry. Java 21 adds a common
 * encounter-order contract.</p>
 *
 * <h2>New interfaces</h2>
 * <ul>
 *   <li>{@link SequencedCollection} — a {@code Collection} with a defined
 *       encounter order. {@code List} and {@code Deque} implement it.
 *       Methods: {@code addFirst}, {@code addLast}, {@code getFirst},
 *       {@code getLast}, {@code removeFirst}, {@code removeLast},
 *       {@code reversed}.</li>
 *   <li>{@link SequencedSet} — a {@code SequencedCollection} that is also a
 *       {@code Set}. {@code LinkedHashSet} and {@code TreeSet} (sorted order)
 *       implement it. {@code addFirst}/{@code addLast} move an existing
 *       element to that end.</li>
 *   <li>{@link SequencedMap} — a {@code Map} with ordered entries.
 *       {@code LinkedHashMap} and {@code TreeMap} implement it.
 *       Methods: {@code firstEntry}, {@code lastEntry}, {@code pollFirstEntry},
 *       {@code pollLastEntry}, {@code putFirst}, {@code putLast},
 *       {@code sequencedKeySet}, {@code sequencedValues},
 *       {@code sequencedEntrySet}, {@code reversed}.</li>
 * </ul>
 *
 * <h2>{@code reversed()} is a view</h2>
 * <p>{@code reversed()} does not copy. It is a live reversed view: mutating
 * the view mutates the original, and vice versa. For an immutable list,
 * {@code reversed()} is also unmodifiable.</p>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code HashSet} and {@code HashMap} are <i>not</i> sequenced — they
 *       have no encounter order.</li>
 *   <li>{@code getFirst}/{@code getLast} on an empty sequenced collection throw
 *       {@link java.util.NoSuchElementException}.</li>
 *   <li>{@code List.getFirst()} is equivalent to {@code get(0)} but also
 *       works uniformly on any {@code SequencedCollection}.</li>
 *   <li>{@code ArrayList} now has {@code addFirst}/{@code addLast} (Java 21)
 *       because {@code List} extends {@code SequencedCollection}.</li>
 * </ul>
 */
public class SequencedCollections {

    public static void main(String[] args) {
        SequencedCollection<String> list = new ArrayList<>(List.of("b", "c"));
        list.addFirst("a");
        list.addLast("d");
        System.out.println(list);              // [a, b, c, d]
        System.out.println(list.getFirst());   // a
        System.out.println(list.getLast());    // d
        System.out.println(list.removeFirst()); // a
        System.out.println(list);              // [b, c, d]

        SequencedCollection<String> backwards = list.reversed();
        System.out.println(backwards);         // [d, c, b]  live view
        backwards.addFirst("e");               // adds to the original's last end
        System.out.println(list);              // [b, c, d, e]
        System.out.println(backwards);         // [e, d, c, b]

        SequencedSet<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("OCP");
        set.add("SE");
        set.addFirst("Java");                  // already present → moved to the front
        System.out.println(set);               // [Java, OCP, SE]
        set.addLast("OCP");                    // moved to the end
        System.out.println(set);               // [Java, SE, OCP]
        System.out.println(set.reversed());    // [OCP, SE, Java]

        SequencedMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Ann", 1);
        map.put("Bob", 2);
        map.putLast("Cara", 3);
        map.putFirst("Zoe", 0);
        System.out.println(map);               // {Zoe=0, Ann=1, Bob=2, Cara=3}
        System.out.println(map.firstEntry());  // Zoe=0
        System.out.println(map.lastEntry());   // Cara=3
        System.out.println(map.pollFirstEntry()); // Zoe=0  (removed)
        System.out.println(map);               // {Ann=1, Bob=2, Cara=3}
        System.out.println(map.reversed());    // {Cara=3, Bob=2, Ann=1}

        SequencedCollection<Integer> deque = new ArrayDeque<>(List.of(1, 2, 3));
        System.out.println(deque.getFirst());  // 1
        System.out.println(deque.getLast());   // 3
    }
}
