package operators;

/**
 * Conditional operators are operators that return a value based on a condition.
 * <ul>
 *   <li>{@code ?:} - Conditional operator</li>
 *   <li>{@code ||} - Logical OR operator</li>
 *   <li>{@code &&} - Logical AND operator</li>
 * </ul>
 */
public class ConditionalOperator {
    public static void main(String[] args) {
        int a = 5, b = 8, c = 12;
        boolean result; // --default to false

       // conditional AND operator
       result = (a > b) && (a > c);
       System.out.println("result -> " + result);

       // conditional OR operator
       result = (a > b) || (a < c);
       System.out.println("result -> " + result);

       //Ternary operator
       result = (a > b) ? true : false;
       System.out.println("result -> " + result);
       
    }
}
