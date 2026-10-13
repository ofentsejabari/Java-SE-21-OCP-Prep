package String;

/**
 * Documents and demonstrates {@link StringBuilder} for the Java SE 21 OCP exam.
 *
 * <h2>What StringBuilder is</h2>
 * <p>{@code StringBuilder} is a <b>mutable</b> sequence of characters. Unlike
 * {@link String}, mutating methods change the same object in place and return
 * {@code this}, so chaining works and you do <i>not</i> need to reassign.</p>
 * <p>It is <b>not</b> thread-safe: public mutators are <i>not</i>
 * {@code synchronized}. That is why it is faster than {@link StringBuffer}
 * and the default choice for single-threaded code. Both live in
 * {@code java.lang} and implement {@link CharSequence}, {@link Appendable},
 * and {@link Comparable}{@code <StringBuilder>} (Java 11+).</p>
 *
 * <h2>String vs StringBuffer vs StringBuilder</h2>
 * <ul>
 *   <li>{@link String} — immutable; every "change" creates a new object.</li>
 *   <li>{@link StringBuffer} — mutable and synchronized (thread-safe, slower).</li>
 *   <li>{@link StringBuilder} — mutable and <i>not</i> synchronized (faster).
 *       Prefer this unless multiple threads share the same buffer.</li>
 * </ul>
 * <p>The method names, overloads, and behavior of {@code StringBuilder} and
 * {@code StringBuffer} are the same. Exam questions often swap the type and
 * ask whether the code still compiles or whether it is thread-safe.</p>
 *
 * <h2>Constructors</h2>
 * <ul>
 *   <li>{@link StringBuilder#StringBuilder()} — empty builder, capacity {@code 16}.</li>
 *   <li>{@link StringBuilder#StringBuilder(int)} — empty builder with given capacity.</li>
 *   <li>{@link StringBuilder#StringBuilder(String)} — copies the string; capacity is
 *       {@code str.length() + 16}.</li>
 *   <li>{@link StringBuilder#StringBuilder(CharSequence)} — copies any CharSequence.</li>
 * </ul>
 *
 * <h2>Length vs capacity</h2>
 * <ul>
 *   <li>{@link StringBuilder#length()} — number of characters currently stored.</li>
 *   <li>{@link StringBuilder#capacity()} — allocated storage (may be larger than
 *       length). Default empty capacity is {@code 16}.</li>
 *   <li>When capacity is exceeded, it typically grows to
 *       {@code (oldCapacity * 2) + 2}.</li>
 *   <li>{@link StringBuilder#ensureCapacity(int)} — grow if needed.</li>
 *   <li>{@link StringBuilder#trimToSize()} — shrink capacity to match length.</li>
 *   <li>{@link StringBuilder#setLength(int)} — truncate or pad with {@code '\0'}.</li>
 * </ul>
 *
 * <h2>Mutating methods (change this object, return this)</h2>
 * <ul>
 *   <li>{@link StringBuilder#append} — add at the end (overloads for String,
 *       primitives, Object, CharSequence, char[], etc.).</li>
 *   <li>{@link StringBuilder#insert(int, String)} — insert at a zero-based index
 *       (overloads for many types).</li>
 *   <li>{@link StringBuilder#delete(int, int)} — remove from {@code start}
 *       inclusive to {@code end} exclusive.</li>
 *   <li>{@link StringBuilder#deleteCharAt(int)} — remove one character.</li>
 *   <li>{@link StringBuilder#replace(int, int, String)} — replace the range
 *       {@code [start, end)} with the given string.</li>
 *   <li>{@link StringBuilder#reverse()} — reverse the character sequence in place.</li>
 *   <li>{@link StringBuilder#setCharAt(int, char)} — replace one character
 *       (returns {@code void}, not {@code this}).</li>
 * </ul>
 *
 * <h2>Reading methods (do not mutate)</h2>
 * <ul>
 *   <li>{@link StringBuilder#charAt(int)} — character at index.</li>
 *   <li>{@link StringBuilder#indexOf(String)} / {@link StringBuilder#lastIndexOf(String)}
 *       — first / last index, or {@code -1}.</li>
 *   <li>{@link StringBuilder#substring(int)} / {@link StringBuilder#substring(int, int)}
 *       — returns a <i>new {@code String}</i>; the builder is unchanged.</li>
 *   <li>{@link StringBuilder#toString()} — snapshot of the current contents as a
 *       {@code String}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Mutators change the same object. {@code sb.append("x");} has an effect
 *       even if you ignore the return value (unlike {@code String}).</li>
 *   <li>{@code substring} returns a {@code String} and does <i>not</i> modify
 *       the builder — a common trap.</li>
 *   <li>{@code delete} / {@code replace} use an exclusive end index, same idea
 *       as {@code String.substring}.</li>
 *   <li>{@code StringBuilder} does <i>not</i> override {@code equals}. Content
 *       equality is reference equality. Compare via {@code toString().equals(...)}
 *       or {@code compareTo} (Java 11+).</li>
 *   <li>{@code setCharAt} returns {@code void} — you cannot chain it.</li>
 *   <li>Invalid indexes throw {@link StringIndexOutOfBoundsException} (or
 *       {@link IndexOutOfBoundsException} depending on the method).</li>
 *   <li>{@code StringBuilder} and {@code StringBuffer} are <i>not</i>
 *       interchangeable with {@code String}: there is no implicit conversion
 *       except via {@code toString()} or concatenation with {@code +}.</li>
 *   <li>Use {@code StringBuilder} unless you need thread safety; use
 *       {@code StringBuffer} only when multiple threads share the buffer.</li>
 * </ul>
 */
public class StringBuilderExample {

    public static void main(String[] args) {
        // -- Constructors: default capacity 16; String ctor adds +16 --
        StringBuilder empty = new StringBuilder();
        System.out.println(empty.capacity());              // 16
        System.out.println(empty.length());                // 0

        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb.capacity());                 // 21  (5 + 16)
        System.out.println(sb.length());                   // 5

        StringBuilder sized = new StringBuilder(32);
        System.out.println(sized.capacity());              // 32

        // -- append: mutates in place and returns this (chaining works) --
        sb.append(" ").append("World");
        System.out.println(sb);                            // Hello World

        // Unlike String, discarding the return value still mutates:
        sb.append("!");
        System.out.println(sb);                            // Hello World!

        // -- insert, delete, replace, reverse --
        StringBuilder buf = new StringBuilder("Java 21");
        buf.insert(5, "SE ");
        System.out.println(buf);                           // Java SE 21

        buf.delete(5, 8);                                  // remove "SE "; end exclusive
        System.out.println(buf);                           // Java 21

        buf.deleteCharAt(4);                               // remove the space
        System.out.println(buf);                           // Java21

        buf.replace(4, 6, " SE 21");                       // [start, end)
        System.out.println(buf);                           // Java SE 21

        buf.reverse();
        System.out.println(buf);                           // 12 ES avaJ
        buf.reverse();                                     // restore

        // -- setCharAt returns void; cannot be chained --
        buf.setCharAt(0, 'j');
        System.out.println(buf);                           // java SE 21

        // -- substring returns a String; the builder is unchanged --
        String slice = buf.substring(0, 4);
        System.out.println(slice);                         // java
        System.out.println(buf);                           // java SE 21  (unchanged)

        // -- length vs capacity vs setLength --
        StringBuilder cap = new StringBuilder("abc");
        System.out.println(cap.length());                  // 3
        System.out.println(cap.capacity());                // 19  (3 + 16)
        cap.setLength(2);                                  // truncate
        System.out.println(cap);                           // ab
        cap.setLength(5);                                  // pad with '\0'
        System.out.println(cap.length());                  // 5

        // -- equals is NOT content-based (Object.equals = same reference) --
        StringBuilder a = new StringBuilder("Hi");
        StringBuilder b = new StringBuilder("Hi");
        System.out.println(a.equals(b));                   // false
        System.out.println(a.toString().equals(b.toString())); // true
        System.out.println(a.compareTo(b));                // 0 (Java 11+)
    }
}
