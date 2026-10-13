package operators;

/**
 * Operator precedence is the rule Java uses to decide which operator runs first in an expression.
 * <b>Higher precedence = evaluated earlier.</b>
 * 
 * Quick order (high → low)
 * <ul>
 *   <li>Postfix: x++, x--</li>
 *   <li>Unary: ++x, --x, +, -, !, ~, cast</li>
 *   <li>Multiplicative: *, /, %</li>
 *   <li>Additive: +, -</li>
 *   <li>Shift: <<, >>, >>></li>
 *   <li>Relational: <, >, <=, >=, instanceof</li>
 *   <li>Equality: ==, !=</li>
 *   <li>Bitwise: &, ^, |</li>
 */
public class OperatorPrecedence {
    public static void main(String[] args) {

        int result = 3 + 4 * 5 - 6 / 2; // 3 + 20 - 3 = 20
        System.out.println("result -> " + result); // 20

        result = (3 + 4) * 5 - 6 / 2; // 7 * 5 - 3 = 32
        System.out.println("result -> " + result); // 32

        result += 80/ 20 % 8 * 3 + -5; // 4 % 8*3+ -5 = 4*3+ -5 = 12 + -5 = 7, result = 32 + 7 = 39
        System.out.println("result -> " + result); // 39


        int x = 8, y = 4, z = 2, sum = 0;
        // sum = x + y - z; // 8 + 4 - 2 = 10
        // System.out.println("sum -> " + sum); // 10

        // sum = x + --y * --z; // 8 + 3 * 1 = 8 + 3 = 11, y = 3, z = 1
        // System.out.println("sum -> " + sum); // 11

        // sum = x + y / z; // 8 + 3 / 1 = 8 + 3 = 11, y = 3, z = 1
        // System.out.println("sum -> " + sum); // 11

        sum = x + y-- + --z * y; // 8 + 4 + 1 * 3 = 8 + 4 + 3 = 15, y = 3, z = 1
        System.out.println("sum -> " + sum); // 15
        

        System.err.println(11%2.0); // 1.0
   
        
    }

}
