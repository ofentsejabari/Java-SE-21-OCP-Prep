package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Documents and demonstrates {@link Map} for the Java SE 21 OCP exam.
 *
 * <h2>What a Map is</h2>
 * <p>A {@code Map} stores <b>unique keys</b> mapped to values. It does
 * <i>not</i> extend {@link java.util.Collection}. Duplicate keys overwrite;
 * values may be duplicated.</p>
 *
 * <h2>Main implementations</h2>
 * <ul>
 *   <li>{@link HashMap} — unordered hash table. Allows one {@code null} key
 *       and many {@code null} values. Average O(1) {@code get}/{@code put}.</li>
 *   <li>{@link LinkedHashMap} — insertion-order (or access-order) iteration.
 *       A {@link java.util.SequencedMap} as of Java 21.</li>
 *   <li>{@link TreeMap} — sorted by key (natural order or a {@code Comparator}).
 *       Keys must be comparable; {@code null} keys are not allowed.</li>
 * </ul>
 *
 * <h2>Core methods</h2>
 * <ul>
 *   <li>{@link Map#put} — insert or replace; returns the <i>previous</i> value
 *       (or {@code null} if the key was new).</li>
 *   <li>{@link Map#get} — value or {@code null} if missing (or if the value
 *       really is {@code null}).</li>
 *   <li>{@link Map#getOrDefault} — value, or the supplied default if missing.</li>
 *   <li>{@link Map#containsKey} / {@link Map#containsValue}.</li>
 *   <li>{@link Map#putIfAbsent} — put only when the key is missing (or mapped
 *       to {@code null}).</li>
 *   <li>{@link Map#replace} / {@link Map#remove} / {@link Map#merge} /
 *       {@link Map#computeIfAbsent}.</li>
 *   <li>Views: {@link Map#keySet}, {@link Map#values}, {@link Map#entrySet}.
 *       These are backed by the map; removing from a view removes from the map.</li>
 * </ul>
 *
 * <h2>Factory methods</h2>
 * <ul>
 *   <li>{@link Map#of Map.of(...)} — immutable; up to 10 key/value pairs;
 *       no {@code null}; duplicate keys throw {@link IllegalArgumentException}.</li>
 *   <li>{@link Map#ofEntries Map.ofEntries(...)} — immutable, any size.</li>
 *   <li>{@link Map#copyOf Map.copyOf(Map)} — immutable copy.</li>
 *   <li>{@link Map#entry Map.entry(k, v)} — an immutable {@code Map.Entry}
 *       for use with {@code ofEntries}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code get} returning {@code null} is ambiguous: missing key <i>or</i>
 *       a {@code null} value. Prefer {@code containsKey} or {@code getOrDefault}.</li>
 *   <li>{@code TreeMap} compares keys with {@code compareTo}, not {@code equals}.</li>
 *   <li>Iterating {@code entrySet()} is the usual way to walk keys and values
 *       together. {@code Map} itself is not {@code Iterable}.</li>
 *   <li>{@code merge(key, value, remappingFunction)}: if the key is missing,
 *       put {@code value}; otherwise replace with {@code remappingFunction.apply(old, value)}.</li>
 * </ul>
 */
public class MapExample {

    public static void main(String[] args) {

        // -- HashMap: unordered hash table. Allows one null key and many null values. Average O(1) get/put.
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ann", 90);
        scores.put("Bob", 75);
        System.out.println(scores.put("Cara", 90));                // duplicate value is fine
        System.out.println(scores.put("Bob", 80)); // 75 — previous value
        System.out.println(scores);            // {Ann=90, Bob=80, Cara=90}  (order not guaranteed)
        System.out.println(scores.get("Ann"));         // 90
        System.out.println(scores.get("Dan"));         // null
        System.out.println("Get or default (DAN): "+scores.getOrDefault("Dan", 0)); // 0
        System.out.println(scores.containsKey("Bob"));     // true
        System.out.println(scores.containsValue(90));      // true

        scores.putIfAbsent("Ann", 100);        // already present — ignored
        scores.putIfAbsent("Dan", 60);         // new key
        System.out.println(scores.get("Ann")); // 90
        System.out.println(scores.get("Dan")); // 60

        scores.merge("Ann", 5, Integer::sum);  // 90 + 5
        System.out.println(scores.get("Ann")); // 95
        scores.computeIfAbsent("Eve", name -> name.length());
        System.out.println(scores.get("Eve")); // 3

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("Score for "+entry.getKey() + " -> " + entry.getValue());
        }

        Map<String, Integer> linked = new LinkedHashMap<>();
        linked.put("first", 1);
        linked.put("second", 2);
        linked.put("third", 3);
        System.out.println(linked);            // {first=1, second=2, third=3}  insertion order

        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put("Cara", 1);
        tree.put("ann", 1);
        tree.put("Bob", 3);
        System.out.println(tree);              // {Ann=2, Bob=3, Cara=1}  sorted by key

        System.out.println("TreeMap in Descending Order: "+tree.descendingMap());

        Map<String, Integer> of = Map.of("a", 1, "b", 2);
        System.out.println(of);
        Map<String, Integer> entries = Map.ofEntries(
                Map.entry("x", 10),
                Map.entry("y", 20)
        );
        System.out.println(entries);
        try {
            of.put("c", 3);
        } catch (UnsupportedOperationException e) {
            System.out.println("Map.of is immutable");
        }
        try {
            Map.of("k", 1, "k", 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Map.of rejects duplicate keys");
        }
    }
}
