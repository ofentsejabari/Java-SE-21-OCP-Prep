package operators;

/**
 * Equality and relational operators are operators that compare two operands.
 * <ul>
 *   <li>{@code ==} - Equality operator</li>
 *   <li>{@code !=} - Inequality operator</li>
 *   <li>{@code >} - Greater than operator</li>
 *   <li>{@code <} - Less than operator</li>
 *   <li>{@code >=} - Greater than or equal to operator</li>
 *   <li>{@code <=} - Less than or equal to operator</li>
 * </ul>
 */
public class EqualityRelationalOperands {
    public static void main(String[] args) {
        int a = 10, b = 10;
        System.out.printf("a == b -> %b%n", (a == b)); // false
        System.out.printf("a != b -> %b%n", (a != b)); // true
        System.out.printf("a > b -> %b%n", (a > b)); // false
        System.out.printf("a < b -> %b%n", (a < b)); // true
        System.out.printf("a >= b -> %b%n", (a >= b)); // false
        System.out.printf("a <= b -> %b%n", (a <= b)); // true
    }

}
