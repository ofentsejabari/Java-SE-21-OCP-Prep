package operators;


/**
 * Unary operators are operators that operate on a single operand.
 * <ul>
 *   <li>{@code +} - Unary plus operator</li>
 *   <li>{@code -} - Unary minus operator</li>
 *   <li>{@code ++} - Increment operator</li>
 *   <li>{@code --} - Decrement operator</li>
 *   <li>{@code !} - Logical not operator</li>
 *   <li>{@code ~} - Bitwise not operator</li>
 * </ul>
 */
public class UnaryOperator {
    public static void main(String[] args) {
        double number  = 7.6;
        boolean isCheck = true;

        System.out.println("number -> " + -number);
        System.out.println("number -> " + +number);
        System.out.println("number++ -> " + number++); // evaluates to the value of number and increment
        System.out.println("number-- -> " + number--); // evaluate and decrement the value of number
        System.out.println("++number -> " + ++number); // increment the value of number and then evaluate
        System.out.println("--number -> " + --number); // decrement the value of number and then evaluate
        System.out.println("isCheck -> " + !isCheck);

        
    }
}
