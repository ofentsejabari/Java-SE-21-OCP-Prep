package String;

/**
 * Documents and demonstrates the {@link String} methods most useful for the
 * Java SE 21 OCP exam. Because {@code String} is immutable, every method that
 * appears to change a string actually returns a <i>new</i> {@code String};
 * the original object is never modified.
 *
 * <h2>Length, emptiness and characters</h2>
 * <ul>
 *   <li>{@link String#length()} — number of {@code char} values (UTF-16 code
 *       units), not Unicode code points.</li>
 *   <li>{@link String#isEmpty()} — {@code true} when {@code length() == 0}.</li>
 *   <li>{@link String#isBlank()} — {@code true} when empty or containing only
 *       Unicode whitespace (Java 11+).</li>
 *   <li>{@link String#charAt(int)} — character at a zero-based index;
 *       throws {@link StringIndexOutOfBoundsException} if out of range.</li>
 *   <li>{@link String#toCharArray()} — copy of the characters as a {@code char[]}.</li>
 * </ul>
 *
 * <h2>Searching and extracting</h2>
 * <ul>
 *   <li>{@link String#indexOf(String)} / {@link String#lastIndexOf(String)} —
 *       first / last index of a substring, or {@code -1} if not found.
 *       Overloads accept a {@code char} and a from-index.</li>
 *   <li>{@link String#contains(CharSequence)} — whether the sequence occurs
 *       anywhere (equivalent to {@code indexOf(...) >= 0}).</li>
 *   <li>{@link String#startsWith(String)} / {@link String#endsWith(String)} —
 *       prefix / suffix checks.</li>
 *   <li>{@link String#substring(int)} / {@link String#substring(int, int)} —
 *       slice from {@code beginIndex} inclusive to {@code endIndex} exclusive.
 *       The end index is exclusive: {@code "Hello".substring(0, 2)} is
 *       {@code "He"}.</li>
 * </ul>
 *
 * <h2>Comparison</h2>
 * <ul>
 *   <li>{@link String#equals(Object)} — case-sensitive content equality.</li>
 *   <li>{@link String#equalsIgnoreCase(String)} — content equality ignoring case.</li>
 *   <li>{@link String#compareTo(String)} — lexicographic order; {@code 0} means
 *       equal, negative means this string is less, positive means greater.</li>
 *   <li>{@link String#compareToIgnoreCase(String)} — same, ignoring case.</li>
 * </ul>
 *
 * <h2>Transforming (always returns a new String)</h2>
 * <ul>
 *   <li>{@link String#concat(String)} — appends another string (same idea as
 *       {@code +}, but a method call).</li>
 *   <li>{@link String#toLowerCase()} / {@link String#toUpperCase()} — case
 *       conversion using the default locale.</li>
 *   <li>{@link String#replace(char, char)} /
 *       {@link String#replace(CharSequence, CharSequence)} — replace all
 *       matching characters or sequences (literal, not regex).</li>
 *   <li>{@link String#replaceAll(String, String)} /
 *       {@link String#replaceFirst(String, String)} — regex replace.</li>
 *   <li>{@link String#repeat(int)} — concatenate this string {@code n} times
 *       (Java 11+).</li>
 *   <li>{@link String#indent(int)} — add or strip leading spaces per line
 *       (Java 12+).</li>
 *   <li>{@link String#formatted(Object...)} — same as {@code String.format}
 *       but invoked on the format string (Java 15+).</li>
 * </ul>
 *
 * <h2>Whitespace</h2>
 * <ul>
 *   <li>{@link String#trim()} — strips leading/trailing characters {@code <= U+0020}
 *       (space and below). Does <i>not</i> remove Unicode whitespace such as
 *       {@code \u2000}.</li>
 *   <li>{@link String#strip()} / {@link String#stripLeading()} /
 *       {@link String#stripTrailing()} — Unicode-aware whitespace removal
 *       (Java 11+). Prefer {@code strip()} over {@code trim()} on the exam
 *       when Unicode whitespace is involved.</li>
 *   <li>{@link String#stripIndent()} — removes incidental indentation from
 *       a multi-line string (Java 15+).</li>
 * </ul>
 *
 * <h2>Splitting, joining and converting</h2>
 * <ul>
 *   <li>{@link String#split(String)} — splits on a <i>regex</i> delimiter into
 *       a {@code String[]}.</li>
 *   <li>{@link String#join(CharSequence, CharSequence...)} — static method that
 *       concatenates pieces with a delimiter.</li>
 *   <li>{@link String#valueOf(Object)} — static conversion of any value
 *       (including primitives) to a string; {@code valueOf(null)} is
 *       {@code "null"}.</li>
 *   <li>{@link String#lines()} — stream of lines from a multi-line string
 *       (Java 11+).</li>
 *   <li>{@link String#matches(String)} — whether the entire string matches a
 *       regex.</li>
 * </ul>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Indexes are zero-based; {@code substring} end is exclusive.</li>
 *   <li>{@code indexOf} returns {@code -1} when the target is missing — it
 *       does not throw.</li>
 *   <li>{@code charAt} and {@code substring} throw
 *       {@link StringIndexOutOfBoundsException} for invalid indexes.</li>
 *   <li>{@code split} and {@code replaceAll} treat the first argument as a
 *       regex: {@code "."} matches every character, not a literal dot.</li>
 *   <li>Discarding the return value (e.g. {@code s.toUpperCase();}) has no
 *       effect on {@code s}.</li>
 *   <li>{@code length()} counts {@code char}s, so a supplementary Unicode
 *       character (surrogate pair) has {@code length() == 2}.</li>
 * </ul>
 */
public class StringMethods {

    public static void main(String[] args) {
        String string = "Hello World";
        String string2 = "Hello World";

        System.out.println(string == string2); // true

        // -- Length, emptiness and characters --
        System.out.println(string.length());           // 11
        System.out.println("".isEmpty());              // true
        System.out.println("   ".isBlank());           // true (whitespace only)
        System.out.println(string.charAt(0));          // 'H'
        System.out.println(string.toCharArray());      // Hello World

        // -- Case conversion (returns a new String; original is unchanged) --
        System.out.println(string.toUpperCase());      // HELLO WORLD
        System.out.println(string.toLowerCase());      // hello world
        System.out.println(string);                    // Hello World

        // -- Extracting: substring(begin) and substring(begin, end exclusive) --
        System.out.println(string.substring(0, 5));    // Hello
        System.out.println(string.substring(6));       // World

        // -- Searching --
        System.out.println(string.indexOf("World"));   // 6
        System.out.println(string.indexOf("xyz"));     // -1 (not found)
        System.out.println(string.lastIndexOf("l"));   // 9
        System.out.println(string.contains("World"));  // true
        System.out.println(string.startsWith("Hello")); // true
        System.out.println(string.endsWith("World"));  // true

        // -- Comparison --
        System.out.println("abc".equals("ABC"));              // false
        System.out.println("abc".equalsIgnoreCase("ABC"));    // true
        System.out.println("abc".compareTo("abd"));           // negative
        System.out.println("abc".compareToIgnoreCase("ABC")); // 0

        // -- Transforming --
        System.out.println(string.concat("!"));               // Hello World!
        System.out.println(string.replace('l', 'L'));         // HeLLo WorLd
        System.out.println(string.replace("World", "Java"));  // Hello Java
        System.out.println("ha".repeat(3));                   // hahaha
        System.out.println("%s is %d".formatted("Java", 21)); // Java is 21

        // -- Whitespace: trim() vs Unicode-aware strip() --
        String padded = "  Hello  ";
        System.out.println("[" + padded.trim() + "]");         // [Hello]
        System.out.println("[" + padded.strip() + "]");        // [Hello]
        System.out.println("[" + padded.stripLeading() + "]"); // [Hello  ]
        System.out.println("[" + padded.stripTrailing() + "]"); // [  Hello]

        // -- Splitting, joining and converting --
        String[] parts = string.split(" ");
        System.out.println(parts[0]);                          // Hello
        System.out.println(parts[1]);                          // World
        System.out.println(String.join("-", "a", "b", "c"));  // a-b-c
        System.out.println(String.valueOf(42));                // 42
        System.out.println("Java 21".matches("Java \\d+"));    // true
    }

}
