package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Documents converting between {@link List} and arrays for the Java SE 21 OCP exam.
 *
 * <h2>List → array</h2>
 * <ul>
 *   <li>{@link List#toArray()} — returns {@code Object[]}. You <i>cannot</i>
 *       cast it to {@code String[]}; that throws {@link ClassCastException}.</li>
 *   <li>{@link List#toArray(Object[]) List.toArray(T[])} — typed copy.
 *       Pass {@code new String[0]} (or {@code new String[list.size()]}).
 *       If the argument is large enough, leftover slots are set to {@code null}.</li>
 *   <li>{@link List#toArray(java.util.function.IntFunction) List.toArray(generator)}
 *       — Java 11+; {@code list.toArray(String[]::new)} is the cleanest form.</li>
 * </ul>
 *
 * <h2>Array → List</h2>
 * <ul>
 *   <li>{@link Arrays#asList Arrays.asList(T...)} — <i>fixed-size</i> <b>view</b>
 *       of the array. {@code set} works and writes through to the array;
 *       {@code add}/{@code remove} throw {@link UnsupportedOperationException}.</li>
 *   <li>{@link List#of List.of(E...)} — immutable <b>copy</b>. Changes to the
 *       original array do <i>not</i> affect the list. No {@code null}.</li>
 *   <li>{@code new ArrayList<>(Arrays.asList(array))} — independent, mutable,
 *       resizable copy.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code Arrays.asList(new int[]{1, 2})} is a {@code List<int[]>} of
 *       <i>one</i> element. Varargs do not unbox primitives. Use
 *       {@code Integer[]} (or {@code List.of(1, 2)}) for a list of numbers.</li>
 *   <li>{@code list.toArray()} is {@code Object[]}, not {@code String[]}.</li>
 *   <li>{@code Arrays.asList} and the array share storage; {@code List.of}
 *       and {@code new ArrayList<>(...)} do not.</li>
 *   <li>A too-small typed array is replaced; a too-large one keeps extra
 *       {@code null}s. Prefer {@code new T[0]} or {@code T[]::new}.</li>
 * </ul>
 */
public class ConversionBetweenListArray {

    public static void main(String[] args) {
        // Starting point for the List → array examples: a mutable ArrayList of three strings.
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // -- List → Object[] (not String[]) --
        // List.toArray() with no arguments always returns Object[], even when the list
        // is List<String>. The runtime array type is Object[], so a cast to String[]
        // fails with ClassCastException. Store the result as Object[], or use the
        // typed overload below.
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects)); // [a, b, c]
        try {
            String[] wrong = (String[]) list.toArray(); // ClassCastException
            System.out.println(wrong);
        } catch (ClassCastException e) {
            System.out.println("toArray() returns Object[], not String[]");
        }

        // -- List → typed array --
        // toArray(T[] a) copies the list into a typed array. Passing new String[0]
        // is the usual idiom: if the argument is too small, the method allocates a
        // new array of the same runtime type and the correct length. The result
        // is a String[], so no cast is needed.
        String[] typed = list.toArray(new String[0]);
        System.out.println(Arrays.toString(typed));   // [a, b, c]

        // Java 11+ generator form: the IntFunction is given the list size and must
        // return a new array of that length. String[]::new is equivalent to
        // size -> new String[size]. Same typed copy as new String[0], cleaner to read.
        String[] generated = list.toArray(String[]::new);
        System.out.println(Arrays.toString(generated)); // [a, b, c]

        // If the supplied array is already large enough, toArray reuses it instead
        // of allocating. Extra slots past list.size() are set to null so you can
        // tell where the copied elements end. Prefer new T[0] or T[]::new unless
        // you need this reuse behaviour.
        String[] oversized = list.toArray(new String[5]);
        System.out.println(Arrays.toString(oversized)); // [a, b, c, null, null]

        // -- Array → fixed-size view (Arrays.asList) --
        // Arrays.asList(T...) does not copy. It wraps the array as a List: same
        // length, same storage. set() writes through to the array, and assigning
        // into the array is visible on the list. The list cannot grow or shrink,
        // so add() and remove() throw UnsupportedOperationException.
        String[] array = {"x", "y", "z"};
        List<String> asList = Arrays.asList(array);
        asList.set(0, "X");                           // allowed: replaces, does not resize
        System.out.println(asList);                   // [X, y, z]
        System.out.println(array[0]);                 // X  (backing array changed)
        array[1] = "Y";                               // change the array…
        System.out.println(asList);                   // [X, Y, z]  (…list sees it)
        try {
            asList.add("w");                          // not allowed: fixed size
        } catch (UnsupportedOperationException e) {
            System.out.println("Arrays.asList is fixed-size");
        }

        // -- Array → immutable copy (List.of) --
        // List.of(E...) copies the elements into an immutable list. Afterwards the
        // original array and the list are independent: changing source[0] does not
        // change the list. set(), add(), and remove() all throw
        // UnsupportedOperationException. List.of also rejects null.
        String[] source = {"p", "q"};
        List<String> of = List.of(source);
        source[0] = "P";                              // mutates the array only
        System.out.println(of);                       // [p, q]  (copy, not a view)
        try {
            of.set(0, "P");                           // not allowed: immutable
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of is immutable");
        }

        // -- Array → mutable, resizable copy --
        // new ArrayList<>(collection) copies every element into a new ArrayList.
        // The copy can grow and shrink, and later changes to either the copy or
        // the original array do not affect the other.
        List<String> copy = new ArrayList<>(Arrays.asList(array));
        copy.add("w");                                // allowed: this list is resizable
        System.out.println(copy);                     // [X, Y, z, w]
        System.out.println(Arrays.toString(array));   // [X, Y, z]  (array unchanged)

        // -- Primitive-array trap --
        // Arrays.asList is a varargs method (T...). A primitive array is one object
        // of type int[], not a sequence of Integer. So asList(new int[]{1, 2, 3})
        // produces List<int[]> with size 1. Autoboxing does not unpack the array.
        // Pass wrapper values (List.of(1, 2, 3) or an Integer[]) for a list of numbers.
        List<int[]> oneElement = Arrays.asList(new int[]{1, 2, 3});
        System.out.println(oneElement.size());        // 1  (List<int[]>, not List<Integer>)
        List<Integer> numbers = List.of(1, 2, 3);     // three autoboxed Integers
        System.out.println(numbers);                  // [1, 2, 3]
        System.out.println(numbers.size());           // 3
    }
}
