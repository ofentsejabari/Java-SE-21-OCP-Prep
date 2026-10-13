package String;

/**
 * String is a sequence of characters.
 * String is immutable.
 * String is thread-safe.
 * String is immutable.
 * StringExample
 */
public class StringExample {

    public static void main(String[] args) {
        // String literal
        String stringLiteral = "Hello ";
        String stringLiteral1 = "World!";
        System.out.println(stringLiteral);
        System.out.println(stringLiteral1);

        // String object
        String stringObject = new String("Hello ");
        String stringObject1 = new String("World!");
        System.out.println(stringObject + stringObject1);
        
        // String concatenation
        String stringConcatenation = stringObject + stringObject1;
        System.out.println(stringConcatenation);
        
        System.out.println(4+5+"2");// -- 92
        System.out.println("2"+4+5);// -- 245
        System.out.println(4+5+"2"+4+5);// -- 9245
       
    }

}
