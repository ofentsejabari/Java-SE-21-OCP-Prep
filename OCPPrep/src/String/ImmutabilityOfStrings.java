package String;

/**
 * Demonstrates the <b>immutability</b> of {@link String} objects in Java.
 *
 * <h2>What immutability means</h2>
 * <p>Once a {@code String} object is created, its internal character data can
 * never be changed. Every method that appears to "modify" a string (such as
 * {@link String#concat(String)}, {@link String#toUpperCase()} or
 * {@link String#replace(char, char)}) actually returns a <i>brand new</i>
 * {@code String} and leaves the original untouched.</p>
 *
 * <h2>Why String is immutable</h2>
 * <ul>
 *   <li><b>String pool safety</b> — pooled literals may be shared by many
 *       references, so allowing mutation would corrupt unrelated code.</li>
 *   <li><b>Security</b> — strings are used for file paths, URLs and credentials;
 *       immutability prevents them from being altered after validation.</li>
 *   <li><b>Thread safety</b> — immutable objects can be shared across threads
 *       without synchronization.</li>
 *   <li><b>Hashing</b> — a cached, stable {@code hashCode()} makes strings ideal
 *       keys for {@link java.util.HashMap}.</li>
 * </ul>
 *
 * <h2>OCP exam tip</h2>
 * <p>A common trap is calling a string method without using its return value.
 * Because the original string is never changed, the result is lost unless it is
 * reassigned (e.g. {@code s = s.concat(" World");}).</p>
 */
public class ImmutabilityOfStrings {

    public static void main(String[] args) {
        // Concatenation with '+' does NOT modify the original "Hello" object;
        // it creates a new String and reassigns 'string' to point at it.
        String string = "Hello";
        string = string + " World";
        System.out.println(string); // "Hello World"

        // concat() returns a new String but the result is discarded here.
        // 'string1' still references the original, unchanged "Hello".
        String string1 = "Hello";
        System.out.println(System.identityHashCode(string1)); 
        string1.concat(" World"); // return value ignored -> no visible effect
        System.out.println(System.identityHashCode(string1));
        System.out.println(string1); // "Hello"
    }

}
