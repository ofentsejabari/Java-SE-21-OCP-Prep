package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Documents sorting and searching collections for the Java SE 21 OCP exam.
 *
 * <h2>Comparable vs Comparator</h2>
 * <ul>
 *   <li>{@link Comparable} — <b>natural order</b>, defined on the class itself
 *       via {@code compareTo}. {@code String}, wrapper types and
 *       {@code LocalDate} already implement it.</li>
 *   <li>{@link Comparator} — an <b>external</b> ordering you pass to
 *       {@code sort}, {@code TreeSet}, {@code TreeMap} or {@code PriorityQueue}.
 *       Use it when you cannot change the class, or you need a different order.</li>
 * </ul>
 * <p>Both return negative / {@code 0} / positive for less / equal / greater.
 * {@code compareTo} must be consistent with {@code equals} for use in
 * {@code SortedSet}/{@code SortedMap}.</p>
 *
 * <h2>How to sort a List</h2>
 * <ul>
 *   <li>{@link Collections#sort(List)} — natural order; elements must be
 *       {@code Comparable}.</li>
 *   <li>{@link Collections#sort(List, Comparator)} — custom order.</li>
 *   <li>{@link List#sort(Comparator)} — instance method; pass {@code null} for
 *       natural order.</li>
 *   <li>Factory helpers: {@link Comparator#comparing}, {@code thenComparing},
 *       {@code reversed}, {@code naturalOrder}, {@code reverseOrder},
 *       {@code nullsFirst}, {@code nullsLast}.</li>
 * </ul>
 *
 * <h2>Searching</h2>
 * <p>{@link Collections#binarySearch} requires the list to be sorted in the
 * <i>same</i> order used for the search. Return value:</p>
 * <ul>
 *   <li>Found → the index.</li>
 *   <li>Missing → {@code -(insertionPoint) - 1}, the same contract as
 *       {@code Arrays.binarySearch}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Sorting a list of a type that is not {@code Comparable}, with no
 *       {@code Comparator}, throws {@link ClassCastException}.</li>
 *   <li>{@code TreeSet}/{@code TreeMap}/{@code PriorityQueue} sort on insert;
 *       you do not call {@code sort} on them.</li>
 *   <li>{@code Comparator.comparing(Student::score).reversed()} is descending
 *       by score; chain {@code thenComparing(Student::name)} for a tie-break.</li>
 *   <li>A binary search on an unsorted list is undefined (wrong or negative
 *       indexes) — same trap as with arrays.</li>
 * </ul>
 */
public class SortingCollections {

    record Student(String name, int score) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            return this.name.compareTo(other.name); // natural order: by name
        }
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Cara", "Ann", "Bob"));
        Collections.sort(names);
        System.out.println(names);             // [Ann, Bob, Cara]
        names.sort(Comparator.reverseOrder());
        System.out.println(names);             // [Cara, Bob, Ann]

        List<Student> classList = new ArrayList<>();
        classList.add(new Student("Cara", 90));
        classList.add(new Student("Ann", 75));
        classList.add(new Student("Bob", 90));

        Collections.sort(classList);           // natural order: name
        System.out.println(classList);         // [Ann, Bob, Cara]

        classList.sort(Comparator.comparingInt(Student::score)
                .reversed()
                .thenComparing(Student::name));
        System.out.println(classList);         // [Bob, Cara, Ann]  high score first; name tie-break

        Comparator<Student> byScore = Comparator.comparingInt(Student::score);
        TreeSet<Student> byScoreSet = new TreeSet<>(byScore.thenComparing(Student::name));
        byScoreSet.addAll(classList);
        System.out.println(byScoreSet);        // Ann(75), then Bob(90), Cara(90)

        List<Integer> nums = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        System.out.println(Collections.binarySearch(nums, 30));  // 2
        System.out.println(Collections.binarySearch(nums, 35));  // -4  (-(3) - 1)

        Collections.reverse(nums);
        System.out.println(nums);              // [50, 40, 30, 20, 10]
        Collections.shuffle(nums);
        System.out.println(nums);              // random permutation
        System.out.println(Collections.min(classList)); // Ann — natural order (name)
        System.out.println(Collections.max(classList, byScore)); // Bob or Cara (score 90)
    }
}
