package String;

/**
 * Documents and demonstrates {@link StringBuffer} for the Java SE 21 OCP exam.
 *
 * <h2>What StringBuffer is</h2>
 * <p>{@code StringBuffer} is a <b>mutable</b> sequence of characters. Unlike
 * {@link String}, mutating methods change the same object in place and return
 * {@code this}, so chaining works and you do <i>not</i> need to reassign.</p>
 * <p>It is <b>thread-safe</b>: every public mutator is {@code synchronized}.
 * For single-threaded code prefer {@link StringBuilder} (same API, faster).
 * Both live in {@code java.lang} and implement {@link CharSequence} and
 * {@link Appendable}.</p>
 *
 * <h2>String vs StringBuffer vs StringBuilder</h2>
 * <ul>
 *   <li>{@link String} — immutable; every "change" creates a new object.</li>
 *   <li>{@link StringBuffer} — mutable and synchronized (thread-safe).</li>
 *   <li>{@link StringBuilder} — mutable and <i>not</i> synchronized (faster).</li>
 * </ul>
 *
 * <h2>Constructors</h2>
 * <ul>
 *   <li>{@link StringBuffer#StringBuffer()} — empty buffer, capacity {@code 16}.</li>
 *   <li>{@link StringBuffer#StringBuffer(int)} — empty buffer with given capacity.</li>
 *   <li>{@link StringBuffer#StringBuffer(String)} — copies the string; capacity is
 *       {@code str.length() + 16}.</li>
 *   <li>{@link StringBuffer#StringBuffer(CharSequence)} — copies any CharSequence.</li>
 * </ul>
 *
 * <h2>Length vs capacity</h2>
 * <ul>
 *   <li>{@link StringBuffer#length()} — number of characters currently stored.</li>
 *   <li>{@link StringBuffer#capacity()} — allocated storage (may be larger than
 *       length). Default empty capacity is {@code 16}.</li>
 *   <li>When capacity is exceeded, it typically grows to
 *       {@code (oldCapacity * 2) + 2}.</li>
 *   <li>{@link StringBuffer#ensureCapacity(int)} — grow if needed.</li>
 *   <li>{@link StringBuffer#trimToSize()} — shrink capacity to match length.</li>
 *   <li>{@link StringBuffer#setLength(int)} — truncate or pad with {@code '\0'}.</li>
 * </ul>
 *
 * <h2>Mutating methods (change this object, return this)</h2>
 * <ul>
 *   <li>{@link StringBuffer#append} — add at the end (overloads for String,
 *       primitives, Object, CharSequence, char[], etc.).</li>
 *   <li>{@link StringBuffer#insert(int, String)} — insert at a zero-based index
 *       (overloads for many types).</li>
 *   <li>{@link StringBuffer#delete(int, int)} — remove from {@code start}
 *       inclusive to {@code end} exclusive.</li>
 *   <li>{@link StringBuffer#deleteCharAt(int)} — remove one character.</li>
 *   <li>{@link StringBuffer#replace(int, int, String)} — replace the range
 *       {@code [start, end)} with the given string.</li>
 *   <li>{@link StringBuffer#reverse()} — reverse the character sequence in place.</li>
 *   <li>{@link StringBuffer#setCharAt(int, char)} — replace one character
 *       (returns {@code void}, not {@code this}).</li>
 * </ul>
 *
 * <h2>Reading methods (do not mutate)</h2>
 * <ul>
 *   <li>{@link StringBuffer#charAt(int)} — character at index.</li>
 *   <li>{@link StringBuffer#indexOf(String)} / {@link StringBuffer#lastIndexOf(String)}
 *       — first / last index, or {@code -1}.</li>
 *   <li>{@link StringBuffer#substring(int)} / {@link StringBuffer#substring(int, int)}
 *       — returns a <i>new {@code String}</i>; the buffer is unchanged.</li>
 *   <li>{@link StringBuffer#toString()} — snapshot of the current contents as a
 *       {@code String}.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Mutators change the same object. {@code sb.append("x");} has an effect
 *       even if you ignore the return value (unlike {@code String}).</li>
 *   <li>{@code substring} returns a {@code String} and does <i>not</i> modify
 *       the buffer — a common trap.</li>
 *   <li>{@code delete} / {@code replace} use an exclusive end index, same idea
 *       as {@code String.substring}.</li>
 *   <li>{@code StringBuffer} does <i>not</i> override {@code equals}. Content
 *       equality is reference equality. Compare via {@code toString().equals(...)}
 *       or {@code compareTo} (Java 11+).</li>
 *   <li>{@code setCharAt} returns {@code void} — you cannot chain it.</li>
 *   <li>Invalid indexes throw {@link StringIndexOutOfBoundsException} (or
 *       {@link IndexOutOfBoundsException} depending on the method).</li>
 *   <li>Use {@code StringBuilder} unless you need thread safety.</li>
 * </ul>
 */
public class StringBufferExample {

    public static void main(String[] args) {
        // -- Constructors: default capacity 16; String ctor adds +16 --
        StringBuffer empty = new StringBuffer();
        System.out.println(empty.capacity());              // 16
        System.out.println(empty.length());                // 0

        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(sb.capacity());                 // 21  (5 + 16)
        System.out.println(sb.length());                   // 5

        StringBuffer sized = new StringBuffer(32);
        System.out.println(sized.capacity());              // 32

        // -- append: mutates in place and returns this (chaining works) --
        sb.append(" ").append("World");
        System.out.println(sb);                            // Hello World

        // Unlike String, discarding the return value still mutates:
        sb.append("!");
        System.out.println(sb);                            // Hello World!

        // -- insert, delete, replace, reverse --
        StringBuffer buf = new StringBuffer("Java 21");
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

        // -- substring returns a String; the buffer is unchanged --
        String slice = buf.substring(0, 4);
        System.out.println(slice);                         // java
        System.out.println(buf);                           // java SE 21  (unchanged)

        // -- length vs capacity vs setLength --
        StringBuffer cap = new StringBuffer("abc");
        System.out.println(cap.length());                  // 3
        System.out.println(cap.capacity());                // 19  (3 + 16)
        cap.setLength(2);                                  // truncate
        System.out.println(cap);                           // ab
        cap.setLength(5);                                  // pad with '\0'
        System.out.println(cap.length());                  // 5

        // -- equals is NOT content-based (Object.equals = same reference) --
        StringBuffer a = new StringBuffer("Hi");
        StringBuffer b = new StringBuffer("Hi");
        System.out.println(a.equals(b));                   // false
        System.out.println(a.toString().equals(b.toString())); // true
        System.out.println(a.compareTo(b));                // 0 (Java 11+)
    }

}
