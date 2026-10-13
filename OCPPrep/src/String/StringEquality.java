package String;

import java.util.Arrays;

/**
 * Demonstrates the difference between reference equality ({@code ==}) and
 * value equality ({@link String#equals(Object)}) for {@link String} instances.
 *
 * <h2>Key concepts</h2>
 * <ul>
 *   <li><b>{@code ==} operator</b> — compares object <i>references</i>, i.e. whether
 *       both variables point to the exact same object in memory.</li>
 *   <li><b>{@code equals()} method</b> — compares the <i>contents</i> (character
 *       sequence) of the two strings, regardless of where they live in memory.</li>
 * </ul>
 *
 * <h2>The String pool</h2>
 * <p>String literals are interned in a special area of the heap called the
 * <b>String Constant Pool</b>. When the same literal appears more than once, the
 * JVM reuses the single pooled instance, so literal references compare equal with
 * {@code ==}. Strings created with {@code new String(...)} always allocate a fresh
 * object outside the pool, so they never share a reference with the pooled literal.</p>
 *
 * <h2>OCP exam tips</h2>
 * <ul>
 *   <li>Prefer {@code equals()} when comparing string content; reserve {@code ==}
 *       for checking object identity.</li>
 *   <li>{@code new String("Hello").intern()} returns the pooled reference, so it
 *       would compare equal to a literal {@code "Hello"} using {@code ==}.</li>
 *   <li>Compile-time constant concatenation (e.g. {@code "Hel" + "lo"}) is folded
 *       into a single pooled literal, while runtime concatenation is not.</li>
 * </ul>
 */
public class StringEquality {

    public static void main(String[] args) {
        /*
        // String literals provide memory efficiency by reusing the same object
        // for identical literals via the String Constant Pool.
        String stringLiteral = "Hello";
        String stringLiteral1 = "Hello";

        // true: both variables reference the same interned literal in the pool.
        System.out.println(stringLiteral == stringLiteral1);
        // true: the character sequences are identical.
        System.out.println(stringLiteral.equals(stringLiteral1));

        // 'new' forces allocation of a distinct object outside the String pool.
        String stringObject = new String("Hello");
        String stringObject1 = new String("Hello");

        // false: each 'new String' is a separate object at a different memory location(heap).
        System.out.println(stringObject == stringObject1);
        // true: the contents are still equal, which is what equals() checks.
        System.out.println(stringObject.equals(stringObject1));

        // System.identityHashCode() is a method that returns the hash code of the object.
        System.out.println(System.identityHashCode(stringLiteral));
        System.out.println(System.identityHashCode(stringLiteral1));
        System.out.println(System.identityHashCode(stringObject));
        System.out.println(System.identityHashCode(stringObject1));

        //equals() method is overridden in the String class to compare the contents of the strings.
        System.out.println(stringLiteral.equals(stringLiteral1)); // true
        System.out.println(stringObject.equals(stringObject1)); // true
        System.out.println(stringLiteral.equals(stringObject)); // true
        System.out.println(stringLiteral1.equals(stringObject1)); // true*/

        // -- Wrapper and primitive equality --
        Integer integer1 = 10;
        Integer integer2 = 10;
        System.out.println(integer1 == integer2); // true
        System.out.println(integer1.equals(integer2)); // true

        Integer integer3 = new Integer(10);
        Integer integer4 = new Integer(10);
        System.out.println(integer3 == integer4); // false


        // -- Arrays equality --
        System.out.println("---------Arrays--------");
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println(array1 == array2); // false
        System.out.println(Arrays.equals(array1, array2)); // true

        String[] stringArray1 = {"Hello", "World"};
        String[] stringArray2 = {"Hello", "World"};
        System.out.println(stringArray1 == stringArray2); // false
        System.out.println(Arrays.equals(stringArray1, stringArray2)); // true
        
        
    }

}
