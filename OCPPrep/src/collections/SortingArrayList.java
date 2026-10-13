package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Documents sorting an {@link ArrayList} for the Java SE 21 OCP exam.
 *
 * <h2>Ways to sort a List</h2>
 * <ul>
 *   <li>{@link Collections#sort(List)} — natural order. Elements must implement
 *       {@link Comparable} ({@code String}, wrappers, {@code LocalDate} do).</li>
 *   <li>{@link Collections#sort(List, Comparator)} — custom order.</li>
 *   <li>{@link List#sort(Comparator)} — instance method (Java 8+). Pass
 *       {@code null} for natural order; same effect as {@code Collections.sort}.</li>
 * </ul>
 * <p>All of these sort <b>in place</b> and return {@code void}. The list must
 * be mutable. {@code ArrayList} is a typical choice because random access is
 * fast; {@code Collections.sort} copies to an array, sorts, then copies back.</p>
 *
 * <h2>Comparator helpers (memorise the names)</h2>
 * <ul>
 *   <li>{@link Comparator#naturalOrder()} / {@link Comparator#reverseOrder()}</li>
 *   <li>{@link Comparator#comparing}, {@code comparingInt}, {@code thenComparing}</li>
 *   <li>{@code reversed()}, {@code nullsFirst()}, {@code nullsLast()}</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code List.of} and {@code Arrays.asList} cannot grow/shrink, but
 *       {@code Arrays.asList} <i>can</i> be sorted ({@code set} is allowed).
 *       {@code List.of} cannot — {@code sort} throws
 *       {@link UnsupportedOperationException}.</li>
 *   <li>Sorting a type that is not {@code Comparable}, with no
 *       {@code Comparator}, throws {@link ClassCastException}.</li>
 *   <li>{@code Collections.sort(list)} and {@code list.sort(null)} are
 *       equivalent natural-order sorts.</li>
 *   <li>{@code Collections.binarySearch} needs the list already sorted in the
 *       <i>same</i> order used for the search.</li>
 * </ul>
 */
public class SortingArrayList {

    public static void main(String[] args) {
        // Unsorted starting point — ArrayList is mutable, so sort() can rearrange it.
        List<String> list = new ArrayList<>();
        list.add("f");
        list.add("Z");
        list.add("d");
        list.add("a");
        list.add("e");
        list.add("c");
        System.out.println(list);              // [f, b, d, a, e, c]

        // -- Natural order (Comparable) --
        // Collections.sort(list) requires elements to be Comparable.
        //
        // String.compareTo is lexicographic: dictionary order, one character at a time.
        // It compares Unicode values of each char (UTF-16 code units), not "human"
        // alphabetizing that ignores case.
        //
        // How it decides:
        //   1. Walk both strings from the left.
        //   2. At the first differing character, the smaller Unicode number comes first.
        //   3. If one string is a prefix of the other, the shorter one comes first
        //      ("app" before "apple").
        //   4. Same characters and same length → equal (compareTo returns 0).
        // compareTo returns negative / 0 / positive (less / equal / greater).
        // Collections.sort uses that to rearrange the list.
        //
        // Why [a, b, c, d, e, f]: 'a' is Unicode 97, 'b' is 98, and so on.
        //
        // Exam traps — this is NOT a human dictionary:
        //   "Zebra" before "apple"  — 'Z' is 90, 'a' is 97. Uppercase before lowercase.
        //   "Java"  before "java"   — 'J' (74) < 'j' (106).
        //   "10"    before "9"      — '1' is 49, '9' is 57. Character order, not numeric.
        //   "app"   before "apple"  — same prefix; shorter string first.
        // Not locale-aware (Swedish ä, German ß, …). That would be Collator, not compareTo.
        Collections.sort(list);
        System.out.println(list);              // [a, b, c, d, e, f]

        // List.sort(null) is the same natural-order sort, as an instance method.
        list.sort(null);
        System.out.println(list);              // [a, b, c, d, e, f]

        // -- Reverse / custom Comparator --
        list.sort(Comparator.reverseOrder());
        System.out.println(list);              // [f, e, d, c, b, a]

        list.sort(Comparator.naturalOrder());
        System.out.println(list);              // [a, b, c, d, e, f]

        // -- Numbers: autoboxed Integer is Comparable --
        List<Integer> nums = new ArrayList<>(List.of(42, 7, 19, 3));
        Collections.sort(nums);
        System.out.println(nums);              // [3, 7, 19, 42]
        nums.sort(Comparator.reverseOrder());
        System.out.println(nums);              // [42, 19, 7, 3]

        // -- Sort by a property (length), then by natural order for ties --
        List<String> words = new ArrayList<>(List.of("pear", "fig", "apple", "kiwi"));
        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(words);             // [fig, kiwi, pear, apple]

        // -- Arrays.asList CAN be sorted (fixed-size, but set is allowed) --
        List<String> asList = java.util.Arrays.asList("c", "a", "D", "200", "100", "50", "10");
        Collections.sort(asList);
        System.out.println(asList);            // [10, 100, 200, 50, D, a, c]

        // -- List.of CANNOT be sorted (immutable) --
        List<String> immutable = List.of("c", "a", "b");
        try {
            Collections.sort(immutable);
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of cannot be sorted");
        }

        // -- Copy first if you need a mutable, sorted version of an immutable list --
        List<String> sortedCopy = new ArrayList<>(immutable);
        Collections.sort(sortedCopy);
        System.out.println(sortedCopy);        // [a, b, c]
        System.out.println(immutable);         // [c, a, b]  original unchanged

        // -- ClassCastException: type is not Comparable and no Comparator --
        List<Object> mixed = new ArrayList<>();
        mixed.add(new Object());
        mixed.add(new Object());
        try {
            Collections.sort(mixed, null);     // same as natural order; Object is not Comparable
        } catch (ClassCastException e) {
            System.out.println("not Comparable: ClassCastException");
        }

        // -- binarySearch requires the list to be sorted in the same order --
        List<String> letters = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f"));
        System.out.println(Collections.binarySearch(letters, "d")); // 3
        System.out.println(Collections.binarySearch(letters, "g")); // -7  (-(6) - 1)


        // Sorting a list of characters


    }
}
