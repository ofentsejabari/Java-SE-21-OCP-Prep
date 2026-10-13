package controlflowstatements;

import java.util.Scanner;

/**
 * While loop is a control flow statement that allows you to repeat a block of code a certain number of times.
 * <ul>
 *   <li>{@code while} - keyword</li>
 *   <li>{@code int i = 0} - initialization</li>
 *   <li>{@code i < 10} - condition</li>
 *   <li>{@code i++} - increment</li>
 * </ul>
 */
public class WhileLoop {

    public static void main(String[] args) {
        // int i = 0;
        // while(i < 10) {
        //     System.out.printf("%d\t", i);
        //     i++;
        // }

        /* -- Factorial of a number 
         * n! = n * (n-1) * (n-2) * ... * 1
         * 5! = 5 * 4 * 3 * 2 * 1 = 120
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        if(number < 0) {
            System.out.println("Number must be positive");
            return; // -- exit the method
        }else if(number == 0 || number == 1) {
            System.out.println("Factorial of " + number + " is 1");
            return;
        }else {
            int factorial = 1;
            int originalNumber = number;
            while(number > 0) {
                factorial *= number;
                number--;
            }
            System.out.println(originalNumber + "! = " + factorial);
        }
    }

}
