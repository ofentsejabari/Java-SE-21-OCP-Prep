package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Documents {@link Collections#binarySearch} for the Java SE 21 OCP exam.
 *
 * <h2>How binary search works</h2>
 * <p>It is divide-and-conquer. The list must already be sorted. On each step
 * the algorithm looks at the middle element and throws away half of the
 * remaining range:</p>
 * <ul>
 *   <li>key equals mid → found; return that index</li>
 *   <li>key is greater → search the right half ({@code low = mid + 1})</li>
 *   <li>key is smaller → search the left half ({@code high = mid - 1})</li>
 * </ul>
 * <p>Time complexity is {@code O(log n)} vs {@code O(n)} for a linear scan.
 * Random-access lists ({@code ArrayList}) are the intended target; on a
 * {@code LinkedList} it still works but is slower because {@code get(mid)}
 * is {@code O(n)}.</p>
 *
 * <h2>Return value (same contract as {@code Arrays.binarySearch})</h2>
 * <ul>
 *   <li>Found → the 0-based index (non-negative).</li>
 *   <li>Missing → {@code -(insertionPoint) - 1}. The insertion point is the
 *       index where the key would be inserted to keep the list sorted
 *       (the first index of an element greater than the key, or
 *       {@code list.size()} if every element is smaller).</li>
 * </ul>
 * <p>Recover the insertion point from a negative result with
 * {@code -result - 1}. Do not assume a miss always returns {@code -1}.</p>
 *
 * <h2>Overloads</h2>
 * <ul>
 *   <li>{@link Collections#binarySearch(List, Object)} — natural order.
 *       Elements must be {@link Comparable}.</li>
 *   <li>{@link Collections#binarySearch(List, Object, Comparator)} — custom
 *       order. Must match the comparator used to sort.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>The list <b>must already be sorted</b> in the <i>same</i> order used
 *       for the search. Searching an unsorted list is undefined (wrong or
 *       negative indexes even when the value is present).</li>
 *   <li>If you sorted with a {@code Comparator}, pass that same comparator
 *       to {@code binarySearch}. Mixing natural order and a custom order is
 *       the same trap as not sorting at all.</li>
 *   <li>Duplicate keys: which matching index is returned is unspecified.</li>
 *   <li>{@code List.of} cannot be sorted. Copy into an {@code ArrayList}
 *       first, then sort, then search.</li>
 * </ul>
 */
public class SearchingList {

    public static void main(String[] args) {
        // Copy List.of into ArrayList so Collections.sort can rearrange it.
        List<Integer> numbers = new ArrayList<>(List.of(17, 2, 3, 4, 51, 6, 7, 81, 9, 10));

        // Binary search REQUIRES a sorted list. Natural order for Integer:
        // [2, 3, 4, 6, 7, 9, 10, 17, 51, 81]
        //  0  1  2  3  4  5   6   7   8   9
        Collections.sort(numbers);
        System.out.println(numbers);

        // -- Found: 51 --
        // Walk-through (low=0, high=9):
        //   mid=4 → 7;  51 > 7  → search right (low=5)
        //   mid=7 → 17; 51 > 17 → search right (low=8)
        //   mid=8 → 51; match   → return 8
        int index = Collections.binarySearch(numbers, 51);
        System.out.println(index);             // 8

        // -- Missing, would insert at the start --
        // 1 is smaller than every element. Insertion point = 0.
        // Return value = -(0) - 1 = -1
        System.out.println(Collections.binarySearch(numbers, 1));  // -1

        // -- Missing, would insert in the middle --
        // 5 sits between 4 (index 2) and 6 (index 3). Insertion point = 3.
        // Return value = -(3) - 1 = -4
        // Exam trap: a miss is NOT always -1.
        System.out.println(Collections.binarySearch(numbers, 5));  // -4

        // -- Missing, would insert at the end --
        // 100 is larger than every element. Insertion point = size (10).
        // Return value = -(10) - 1 = -11
        System.out.println(Collections.binarySearch(numbers, 100)); // -11

        // Recover the insertion point from a negative result:
        //   insertionPoint = -result - 1
        int miss = Collections.binarySearch(numbers, 5);
        int insertionPoint = -miss - 1;        // 3
        System.out.println(insertionPoint);
        numbers.add(insertionPoint, 5);
        System.out.println(numbers);           // [2, 3, 4, 5, 6, 7, 9, 10, 17, 51, 81]

        // -- Arrays.binarySearch: same contract, for arrays --
        int[] arr = {2, 3, 4, 6, 7, 9, 10, 17, 51, 81};
        System.out.println(Arrays.binarySearch(arr, 51)); // 8
        System.out.println(Arrays.binarySearch(arr, 5));  // -4

        // -- Custom Comparator: sort and search must use the SAME order --
        List<Integer> descending = new ArrayList<>(List.of(17, 2, 3, 4, 51, 6, 7, 81, 9, 10));
        Comparator<Integer> reverse = Comparator.reverseOrder();
        descending.sort(reverse);
        System.out.println(descending);        // [81, 51, 17, 10, 9, 7, 6, 4, 3, 2]
        System.out.println(Collections.binarySearch(descending, 51, reverse)); // 1

        // Trap: list is reverse-sorted, but binarySearch uses natural order.
        // Result is undefined — do not rely on it finding 51.
        System.out.println(Collections.binarySearch(descending, 51)); // undefined

        // -- Strings: natural (Unicode) order, not numeric --
        List<String> words = new ArrayList<>(List.of("pear", "fig", "apple", "kiwi"));
        Collections.sort(words);
        System.out.println(words);             // [apple, fig, kiwi, pear]
        System.out.println(Collections.binarySearch(words, "kiwi"));  // 2
        System.out.println(Collections.binarySearch(words, "grape")); // -3  (-(2) - 1)

        // -- Duplicates: which equal index is returned is unspecified --
        List<Integer> dupes = new ArrayList<>(List.of(1, 2, 2, 2, 3));
        int anyTwo = Collections.binarySearch(dupes, 2);
        System.out.println(anyTwo);            // 1, 2, or 3 — not guaranteed
    }

}
