package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Documents and demonstrates {@link Queue} and {@link Deque} for the Java SE 21 OCP exam.
 *
 * <h2>Queue vs Deque</h2>
 * <ul>
 *   <li>{@code Queue} — typically FIFO: insert at the tail, take from the head.</li>
 *   <li>{@code Deque} ("deck") — double-ended: insert/remove at both ends.
 *       Use it as a queue <i>or</i> as a stack. Prefer {@link ArrayDeque}
 *       over the legacy {@link java.util.Stack} class.</li>
 * </ul>
 *
 * <h2>Two method families (exam favourite)</h2>
 * <p>Each operation has a version that <b>throws</b> and a version that
 * <b>returns a special value</b> ({@code false} or {@code null}) on failure:</p>
 * <pre>
 *           Throws               Special value
 * insert    add(e)               offer(e)     → false if full
 * remove    remove()             poll()       → null if empty
 * examine   element()            peek()       → null if empty
 * </pre>
 * <p>The same pattern exists at both ends of a {@code Deque}:
 * {@code addFirst}/{@code offerFirst}, {@code removeLast}/{@code pollLast},
 * {@code getFirst}/{@code peekFirst}, and so on.</p>
 *
 * <h2>Main implementations</h2>
 * <ul>
 *   <li>{@link ArrayDeque} — resizable circular array. Fast, no capacity limit
 *       in practice. Does <i>not</i> allow {@code null}. Preferred {@code Deque}
 *       and stack. A {@link java.util.SequencedCollection} as of Java 21.</li>
 *   <li>{@link LinkedList} — also a {@code List} and {@code Deque}. Allows
 *       {@code null} (which makes {@code poll}/{@code peek} returning {@code null}
 *       ambiguous).</li>
 *   <li>{@link PriorityQueue} — binary heap. Head is the <i>smallest</i> element
 *       by natural order or a {@code Comparator}. Iteration order is <i>not</i>
 *       sorted — only {@code poll} / {@code peek} honour priority. No {@code null}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>{@code ArrayDeque} and {@code PriorityQueue} throw
 *       {@link NullPointerException} on {@code null} elements.</li>
 *   <li>{@code pop()} / {@code push(e)} are the stack-style {@code Deque} methods
 *       ({@code pop} is {@code removeFirst}; {@code push} is {@code addFirst}).</li>
 *   <li>{@code PriorityQueue} of a custom type needs {@code Comparable} or a
 *       {@code Comparator} — otherwise {@code add} throws {@code ClassCastException}.</li>
 *   <li>Calling {@code remove()} or {@code element()} on an empty queue throws
 *       {@link java.util.NoSuchElementException}; {@code poll()} and {@code peek()}
 *       return {@code null}.</li>
 * </ul>
 */
public class QueueExample {

    public static void main(String[] args) {
        // -- Deque: both queue and stack. Can remove elements from both ends.
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("Goat");
        deque.offer("Cow");
        deque.offer("Sheep");
        deque.offerFirst("Horse");
        deque.addLast("Chicken");
        deque.push("Dog");
        deque.push("Dog");
        deque.offerLast("Cat");
        deque.offerLast("Rabbit");
        deque.offerLast("Mouse");
    
        System.out.println(deque);

        System.out.println("Remove first element (throws NoSuchElementException if empty): "+deque.removeFirst());
        System.out.println("Remove last element (returns null if empty): "+deque.pollLast());
        System.out.println("Peek first element (returns null if empty): "+deque.peekFirst());
        System.out.println("Peek last element (returns null if empty): "+deque.peekLast());
        System.out.println("Remove first element (throws NoSuchElementException if empty): "+deque.removeFirst());
        System.out.println("Remove last element (throws NoSuchElementException if empty): "+deque.removeLast());
        System.out.println("Deque after remove and poll: "+deque);

        Deque<String> stack = new ArrayDeque<>();
        stack.push("bottom");
        stack.push("middle");
        stack.push("top");
        System.out.println(stack.pop());       // top   (LIFO)
        System.out.println(stack.pop());       // middle
        System.out.println(stack.peek());      // bottom

        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.addLast(10);                     // enqueue at tail
        // deque.addLast(20);
        // deque.addFirst(5);                     // insert at head
        // System.out.println(deque);             // [5, 10, 20]
        // System.out.println(deque.removeFirst()); // 5
        // System.out.println(deque.removeLast());  // 20

        Queue<Integer> priority = new PriorityQueue<>();
        priority.offer(30);
        priority.offer(10);
        priority.offer(20);
        System.out.println(priority.peek());   // 10 — smallest is the head
        while (!priority.isEmpty()) {
            System.out.print(priority.poll() + " "); // 10 20 30
        }
        System.out.println();

        Queue<String> linkedQueue = new LinkedList<>();
        linkedQueue.add("Mercedes");
        linkedQueue.offer("BMW");
        linkedQueue.offer("Toyota");
        linkedQueue.offer(null);               // LinkedList allows null; ArrayDeque does not
        System.out.println(linkedQueue);       // [Mercedes, BMW, Toyota, null]

        System.out.println("Remove first element (throws NoSuchElementException if empty): "+linkedQueue.remove());
        System.out.println("Remove first element (returns null if empty): "+linkedQueue.poll());
        System.out.println("Peek first element (returns null if empty): "+linkedQueue.peek());
        System.out.println("Remove first element (throws NoSuchElementException if empty): "+linkedQueue.element());
        System.out.println("LinkedQueue after remove and poll: "+linkedQueue);
    }
}
