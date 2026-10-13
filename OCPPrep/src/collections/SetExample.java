package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Documents and demonstrates {@link Set} for the Java SE 21 OCP exam.
 *
 * <h2>What a Set is</h2>
 * <p>A {@code Set} holds <b>unique</b> elements: adding a duplicate is ignored
 * and {@code add} returns {@code false}. There is no index; you cannot
 * {@code get(i)}.</p>
 * <p>Uniqueness is defined by {@code equals} (and, for hash-based sets,
 * {@code hashCode} must be consistent with {@code equals}).</p>
 *
 * <h2>Main implementations</h2>
 * <ul>
 *   <li>{@link HashSet} — unordered (hash table). Allows one {@code null}.
 *       Average O(1) add/contains/remove. Backed by a {@code HashMap}.</li>
 *   <li>{@link LinkedHashSet} — insertion-order iteration. Allows one {@code null}.
 *       A {@link java.util.SequencedSet} as of Java 21.</li>
 *   <li>{@link TreeSet} — sorted (red-black tree). Elements must be
 *       {@link Comparable} or you must supply a {@link java.util.Comparator}.
 *       Does <i>not</i> allow {@code null}. Implements {@code NavigableSet}.</li>
 * </ul>
 *
 * <h2>Factory methods</h2>
 * <ul>
 *   <li>{@link Set#of Set.of(...)} — immutable, no {@code null}, no duplicates
 *       (a duplicate argument throws {@link IllegalArgumentException}).</li>
 *   <li>{@link Set#copyOf Set.copyOf(Collection)} — immutable copy; rejects
 *       {@code null} elements.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code HashSet} iteration order is not guaranteed and can change
 *       between runs. Never assert a specific order on the exam unless the
 *       type is {@code LinkedHashSet} or {@code TreeSet}.</li>
 *   <li>{@code TreeSet} uses {@code compareTo}, not {@code equals}, to decide
 *       uniqueness. Inconsistent {@code compareTo}/{@code equals} causes
 *       surprising "duplicate" behaviour.</li>
 *   <li>Inserting {@code null} into a {@code TreeSet} throws
 *       {@link NullPointerException}.</li>
 *   <li>A record's generated {@code equals}/{@code hashCode} make it a natural
 *       {@code HashSet} element.</li>
 * </ul>
 */
public class SetExample {

    public static void main(String[] args) {

        // -- Store elements in no order
        Set<String> hash = new HashSet<>();
        hash.add("Java");  // true
        hash.add("Java");  // false — duplicate
        hash.add("OCP");
        hash.add("SE");
        hash.add("21");
        System.out.println(hash);              // unordered, e.g. [Java, SE, OCP]
        System.out.println("contains OCP: "+hash.contains("OCP")); // true

        // -- Store elements in insertion order
        Set<String> carsLinkedHashSet = new LinkedHashSet<>();
        carsLinkedHashSet.add("BMW");
        carsLinkedHashSet.add("Mercedes");
        carsLinkedHashSet.add("Toyota");
        carsLinkedHashSet.add("BMW");                    // ignored
        System.out.println(carsLinkedHashSet);            // [BMW, Mercedes, Toyota]  insertion order

        // -- Store elements in natural order
        TreeSet<String> tree = new TreeSet<>();
        tree.add("OCP");
        tree.add("Java");
        tree.add("SE");
        System.out.println(tree);              // [Java, OCP, SE]  natural (alphabetical) order
        System.out.println(tree.first());      // Java
        System.out.println(tree.last());       // SE
        System.out.println(tree.ceiling("K")); // OCP (least >= "K")
        

        // -- Elements are sorted in natural order by default
        TreeSet<Character> treeSet = new TreeSet<>(Set.of('a','j', 'b', 'c', 'd', 'f', 'e', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        System.out.println(treeSet);
        
        // -- Elements are sorted in descending order
        System.out.println("Descending: "+treeSet.descendingSet());

        System.out.println("HeadSet (elements less than 'f'): "+treeSet.headSet('f'));
        System.out.println("TailSet (elements greater than or equal to 'f'): "+treeSet.tailSet('f'));
        System.out.println("SubSet (elements between 'a' and 'f'): "+treeSet.subSet('a', 'f'));
        System.out.println("Poll First (Remove and return the first element): "+treeSet.pollFirst());
        System.out.println("Poll Last (Remove and return the last element): "+treeSet.pollLast());

        System.out.println("TreeSet after poll first and last: "+treeSet);    


        // try {
        //     tree.add(null);
        // } catch (NullPointerException e) {
        //     System.out.println("TreeSet rejects null");
        // }

        // hash.add(null);
        // System.out.println(hash.contains(null)); // true — HashSet allows one null

        // Set<String> of = Set.of("a", "b", "c");
        // System.out.println(of);                // immutable, order not specified
        // try {
        //     Set.of("a", "a");
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Set.of rejects duplicates");
        // }
        // try {
        //     of.add("d");
        // } catch (UnsupportedOperationException e) {
        //     System.out.println("Set.of is immutable");
        // }

        // record City(String name) {}
        // Set<City> cities = new HashSet<>();
        // cities.add(new City("Paris"));
        // cities.add(new City("Paris"));         // equal record → duplicate ignored
        // System.out.println(cities.size());     // 1


        // /// Comparing sets
        // Set<String> set1 = new HashSet<>(Set.of("a", "b", "c", "d"));
        // Set<String> set2 = new HashSet<>(Set.of("a", "b", "c"));

        // Set<String> union = new HashSet<>(set1);
        // union.addAll(set2);
        // System.out.println("Union: "+ union);

        // Set<String> intersection = new HashSet<>(set1);
        // intersection.retainAll(set2);
        // System.out.println("Intersection: "+intersection);

        // Set<String> difference = new HashSet<>(set1);
        // difference.removeAll(set2);
        // System.out.println("Difference: "+ difference);


        // System.out.println("Equals: "+ set1.equals(set2));
        // System.out.println("Subset: "+ set1.containsAll(set2));
        // System.out.println("Superset: "+ set1.containsAll(set2));
    }
}
