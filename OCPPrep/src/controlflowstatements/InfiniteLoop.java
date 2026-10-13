package controlflowstatements;

import java.util.Random;
import java.util.Scanner;

/**
 * Infinite loop is a loop that runs forever.
 * <ul>
 *   <li>{@code for(;;) - keyword</li>
 *   <li>{@code int i = 0} - initialization</li>
 *   <li>{@code i < 10} - condition</li>
 *   <li>{@code i++} - increment</li>
 * </ul>
 */
public class InfiniteLoop {

    public static void main(String[] args) {
        // -- Number guessing game
        Random random = new Random();
        int randomNumber = random.nextInt(5, 100); // 5 to 99

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 5 and 99: ");

        int attempts = 0;
        while(true) {
            attempts++;
            int number = scanner.nextInt();
            if(number < 5 || number > 99) {
                System.out.println("Number must be between 5 and 99");
                continue; // -- skip current iteration and go to the next iteration of the same loop or switch statement.
            }else if(number < randomNumber) {
                System.out.println("Too low");
                continue;
            }else if(number > randomNumber) {
                System.out.println("Too high");
                continue;
            }else {
                System.out.println("You guessed the number!");
                break; // -- exit the loop
            }
        }
        scanner.close();
        System.out.println("You guessed the number " + randomNumber + " in " + attempts + " attempts");
    }

}
