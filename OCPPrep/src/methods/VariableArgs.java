package methods;

import java.util.Scanner;

/**
 * Variable arguments are a feature of Java that allows a method to take a variable number of arguments.
 * <p>
 * The method declaration is:
 * <pre>
 * public static void methodName(String... names) { ... }
 * </pre>
 * <p>
 */
public class VariableArgs {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a number separated by spaces: ");
            String input = scanner.hasNextLine() ? scanner.nextLine() : "";
            if(!input.isEmpty()) {
                sumNumbers(input.split(" "));
            }else {
                System.out.println("No numbers entered");
                continue;
            }

            System.out.println("Do you want to exit? (y/n)");
            char exit = scanner.nextLine().charAt(0);
            if(exit == 'y' || exit == 'Y') {
                System.out.println("Exiting...");
                break;   
            }
        }
        scanner.close();
    }

    public static void sumNumbers(String... numbers) { // -- 

        int sum = 0;
        String enteredNumbers = "";

        for(int i = 0; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
            enteredNumbers += numbers[i] + (i < numbers.length - 1 ? " + " : "");
        }

        System.out.println(enteredNumbers + " = " + sum);
    }

}
