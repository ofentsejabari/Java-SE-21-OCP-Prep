package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
       

        System.out.println("Enter the operator: (+, -, *, /, %)");
        char operator = scanner.next().charAt(0);

        scanner.close();
        int result = 0;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            case '%':
                result = number1 % number2;
                break; // Exits the switch statement
            default:
                System.out.println("Invalid operator");
                break; // Termnates the current method
        }
        System.out.printf("%d %c %d = %d%n", number1, operator, number2, result);
    }

    /**
     * Public method is accessible everywhere.
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        return a / b;
    }

    /**
     * Private method is accessible only within the same class (Calculator.java).
     * @param a
     * @param b
     * @return
     */
    private int add(int a, int b) {
        return a + b;
    }


    /**
     * Protected method is accessible within the same package and subclasses.(calculator package)
     * @param a
     * @param b
     * @return
     */
    protected int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Default method is accessible only within the same package.(calculator package)
     * @param a
     * @param b
     * @return
     */
    int multiply(int a, int b) {
        return a * b;
    }
    
    
}
