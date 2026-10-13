package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Documents {@link Iterator} and {@link ListIterator} for the Java SE 21 OCP exam.
 *
 * <h2>Iterator — walk any Collection one way</h2>
 * <p>{@code Iterator} is the standard way to traverse a {@link java.util.Collection}.
 * Every Collection has {@code iterator()}. The cursor sits <b>between</b> elements,
 * not on them. Starting cursor: before the first element.</p>
 * <ul>
 *   <li>{@link Iterator#hasNext()} — {@code true} if another element is ahead.</li>
 *   <li>{@link Iterator#next()} — move forward and return that element.
 *       Throws {@link java.util.NoSuchElementException} if there is none.</li>
 *   <li>{@link Iterator#remove()} — remove the <i>last element returned</i> by
 *       {@code next()}. Must call {@code next()} first; calling {@code remove()}
 *       twice in a row throws {@link IllegalStateException}.</li>
 * </ul>
 * <p>{@code Iterator} has no {@code add}, {@code set}, or backward walk.
 * {@code forEachRemaining(Consumer)} (Java 8+) consumes whatever is left.</p>
 *
 * <h2>ListIterator — List-only, two-way, can modify</h2>
 * <p>{@link ListIterator} extends {@code Iterator} and is available only on
 * {@link List} via {@code listIterator()} or {@code listIterator(index)}.
 * The optional start index is where the cursor is placed (0 = before first).</p>
 * <ul>
 *   <li>{@link ListIterator#hasPrevious()} / {@link ListIterator#previous()} —
 *       walk backward. {@code previous()} throws {@code NoSuchElementException}
 *       if already at the start.</li>
 *   <li>{@link ListIterator#nextIndex()} / {@link ListIterator#previousIndex()} —
 *       index that {@code next()} / {@code previous()} would return, or
 *       {@code size()} / {@code -1} at the ends.</li>
 *   <li>{@link ListIterator#set(Object)} — replace the last element returned
 *       by {@code next()} or {@code previous()}.</li>
 *   <li>{@link ListIterator#add(Object)} — insert <i>before</i> the element
 *       that would be returned by {@code next()} (after {@code previous()}).
 *       After {@code add}, the new element is behind the cursor, so
 *       {@code next()} does not return it again; {@code previous()} does.</li>
 * </ul>
 *
 * <h2>Cursor picture (list [A, B, C])</h2>
 * <pre>
 *   | A | B | C |      start: next() → A, previous() would fail
 *   A | B | C |        after next(): last returned = A
 *   A | B | C |        after next() again: last returned = B
 *   A | B | C |        after previous(): last returned = B again
 * </pre>
 * <p>{@code set}/{@code remove} always act on that "last returned" element.</p>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Enhanced-for uses an Iterator under the hood. Modifying the list
 *       (add/remove) during that loop throws
 *       {@link java.util.ConcurrentModificationException} (fail-fast).
 *       Safe: {@code Iterator.remove()} or {@code list.removeIf(...)}.</li>
 *   <li>{@code iterator()} works on Set, Queue, List. {@code listIterator()}
 *       is List-only — it will not compile on a Set.</li>
 *   <li>{@code List.of} is immutable: {@code iterator.remove()},
 *       {@code listIterator.add}/{@code set} throw
 *       {@link UnsupportedOperationException}.</li>
 *   <li>{@code listIterator(list.size())} starts at the end — useful for
 *       a reverse walk with {@code hasPrevious()}/{@code previous()}.</li>
 *   <li>{@code next()} then {@code remove()} is legal. {@code remove()}
 *       without a prior {@code next}/{@code previous} is not.</li>
 * </ul>
 */
public class ListIteratorExample {

    public static void main(String[] args) {
        // demoIterator();
        demoListIteratorForwardAndBack();
        demoSetAddRemove();
        demoStartAtEnd();
        demoFailFast();
    }

    /** Iterator: one-way walk + remove the last element next() returned. */
    private static void demoIterator() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            if (n % 2 == 0) {
                iterator.remove();             // legal: last returned by next()
            }
        }
        System.out.println(numbers);           // [1, 3, 5, 7, 9]
    }

    /** ListIterator: forward, then backward; indexes sit around the cursor. */
    private static void demoListIteratorForwardAndBack() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ListIterator<Integer> it = numbers.listIterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " "); // 1 2 3 4 5
        }
        System.out.println();
        System.out.println(it.nextIndex());    // 5  (size — no next element)
        System.out.println(it.previousIndex()); // 4

        while (it.hasPrevious()) {
            System.out.print(it.previous() + " "); // 5 4 3 2 1
        }
        System.out.println();
        System.out.println(it.nextIndex());    // 0
        System.out.println(it.previousIndex()); // -1 (no previous element)
    }

    /** set replaces last returned; add inserts at the cursor; remove uses last returned. */
    private static void demoSetAddRemove() {
        List<String> letters = new ArrayList<>(List.of("a", "b", "c"));
        ListIterator<String> it = letters.listIterator();

        it.next();                             // last returned = "a"
        it.set("A");                           // replace "a"
        it.add("X");                           // insert after "A", before "b"
        System.out.println(letters);           // [A, X, b, c]

        it.next();                             // last returned = "b"
        it.remove();                           // remove "b"
        System.out.println(letters);           // [A, X, c]
    }

    /** listIterator(size) places the cursor after the last element. */
    private static void demoStartAtEnd() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        ListIterator<Integer> it = numbers.listIterator(numbers.size());
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " "); // 3 2 1
        }
        System.out.println();
        
    }

    /** Structural change on the list (not via this iterator) is fail-fast. */
    private static void demoFailFast() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        Iterator<Integer> iterator = numbers.iterator();
        iterator.next();
        numbers.add(4);                        // structural change besides this iterator
        try {
            iterator.next();
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("fail-fast: ConcurrentModificationException");
        }
    }
}
