package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Documents and demonstrates {@link List} for the Java SE 21 OCP exam.
 *
 * <h2>What a List is</h2>
 * <p>A {@code List} is an <b>ordered</b>, <b>indexed</b> collection that
 * <b>allows duplicates</b> and (for most implementations) {@code null}.
 * Elements are accessed by a zero-based index.</p>
 *
 * <h2>Main implementations</h2>
 * <ul>
 *   <li>{@link ArrayList} — resizable array. Fast random access ({@code get}/{@code set}).
 *       Adding/removing in the middle shifts later elements. Default initial
 *       capacity is {@code 10}.</li>
 *   <li>{@link LinkedList} — doubly linked nodes. Fast add/remove at the ends;
 *       slow random access. Also implements {@link java.util.Deque}.</li>
 * </ul>
 *
 * <h2>How the list is created matters</h2>
 * <ul>
 *   <li>{@code new ArrayList<>()} — mutable, resizable, allows {@code null}.</li>
 *   <li>{@link List#of List.of(...)} — immutable, <i>no</i> {@code null},
 *       {@code add}/{@code set}/{@code remove} throw
 *       {@link UnsupportedOperationException}.</li>
 *   <li>{@link Arrays#asList Arrays.asList(...)} — <i>fixed-size</i> view of an
 *       array. {@code set} works; {@code add}/{@code remove} throw
 *       {@code UnsupportedOperationException}. Changes flow both ways between
 *       the list and the backing array.</li>
 *   <li>{@code new ArrayList<>(List.of(...))} — mutable copy of an immutable list.</li>
 *   <li>{@link Collections#unmodifiableList} — unmodifiable <i>view</i> of a
 *       backing list; the original can still change.</li>
 * </ul>
 *
 * <h2>List-specific methods</h2>
 * <ul>
 *   <li>{@link List#get(int)} / {@link List#set(int, Object)} — read / replace at index.</li>
 *   <li>{@link List#add(int, Object)} — insert at index (shifts later elements).</li>
 *   <li>{@link List#remove(int)} — remove by <i>index</i> (overloaded with
 *       {@code remove(Object)}).</li>
 *   <li>{@link List#indexOf} / {@link List#lastIndexOf} — first / last index, or
 *       {@code -1} if missing.</li>
 *   <li>{@link List#subList(int, int)} — live view from begin (inclusive) to end
 *       (exclusive). Changes to the view change the original.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>For {@code List<Integer>}, {@code remove(1)} calls {@code remove(int index)},
 *       not {@code remove(Object)}. Use {@code remove(Integer.valueOf(1))} to
 *       remove the value {@code 1}.</li>
 *   <li>{@code List.of} rejects {@code null} with {@link NullPointerException}.</li>
 *   <li>Invalid indexes throw {@link IndexOutOfBoundsException}.</li>
 *   <li>Modifying a list while iterating it with an enhanced-for loop throws
 *       {@link java.util.ConcurrentModificationException}. Use {@code Iterator.remove}
 *       or {@code removeIf} instead.</li>
 * </ul>
 */
public class ListExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ann"); // insert at the end of the list
        names.add("Bob");
        names.add("Cara");
        names.add(1, "Bea");                   // insert at index 1
        System.out.println(names);             // [Ann, Bea, Bob, Cara]
        System.out.println(names.get(0));      // Ann
        names.set(0, "Amy"); // replace the element at index 0 with "Amy"
        System.out.println(names);             // [Amy, Bea, Bob, Cara]
        System.out.println(names.indexOf("Bob"));     // 2
        System.out.println(names.remove(1));   // Bea  (removed by index)
        System.out.println(names);             // [Amy, Bob, Cara]
        System.out.println(names.size());   // 3

        List<String> linked = new LinkedList<>(names);
        linked.addFirst("Zoe");                // Deque / SequencedCollection (Java 21)
        System.out.println(linked);            // [Zoe, Amy, Bob, Cara]

        // -- List.of: immutable, no null --
        List<String> of = List.of("a", "b", "c");
        System.out.println(of);                // [a, b, c]
        try {
            of.add("d");
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of is immutable");
        }

        // -- Arrays.asList: fixed size, set is allowed --
        String[] array = {"x", "y", "z"};
        List<String> asList = Arrays.asList(array);
        asList.set(0, "X");
        System.out.println(asList);            // [X, y, z]
        System.out.println(array[0]);          // X  (backing array changed)
        try {
            asList.add("w");
        } catch (UnsupportedOperationException e) {
            System.out.println("Arrays.asList is fixed-size");
        }

        // -- Mutable copy --
        List<String> copy = new ArrayList<>(List.of("a", "b"));
        copy.add("c");
        System.out.println(copy);              // [a, b, c]

        // -- remove(int) vs remove(Object) trap --
        List<Integer> nums = new ArrayList<>(List.of(10, 20, 30));
        nums.remove(1);                        // removes INDEX 1, not the value 1
        System.out.println(nums);              // [10, 30]
        nums.remove(Integer.valueOf(10));      // removes the OBJECT 10
        System.out.println(nums);              // [30]

        // -- subList is a live view (end index exclusive) --
        List<String> letters = new ArrayList<>(List.of("a", "b", "c", "d"));
        List<String> middle = letters.subList(1, 3);
        System.out.println(middle);            // [b, c]
        middle.set(0, "B");
        System.out.println(letters);           // [a, B, c, d]

        // Clear()
        letters.clear();                       // remove all elements
        System.out.println(letters);           // []

        // isEmpty()
        System.out.println(letters.isEmpty()); // true

        // size()
        System.out.println(letters.size());    // 0

        

    }
}
