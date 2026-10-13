package controlflowstatements;

import java.util.Arrays;

/**
 * For loop is a control flow statement that allows you to repeat a block of code a certain number of times.
 * <ul>
 *   <li>{@code for} - keyword</li>
 *   <li>{@code int i = 0} - initialization</li>
 *   <li>{@code i < 10} - condition</li>
 *   <li>{@code i++} - increment</li>
 * </ul>
 */
public class ForLoop {
    public static void main(String[] args) {
        // for(int a = 0, b = 1; a <= 5 && b < 11; ++a, b+=1) {
        //     System.out.println("a -> " + a + " b -> " + b);
        // }

        // -- Infinte loop
        // for(;;) {
        //     System.out.println("Infinte loop");
        // }

        int[][] numbers = new int[3][3];
        // -- Nested loop
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                numbers[i][j] = i + j;
            }
        }
        System.out.println("numbers: " + Arrays.deepToString(numbers));


        String animals[] = {"dog", "cat", "bird", "fish", "horse"};
        for(String animal : animals) {
            if (animal.equals("bird")) {
                continue; // continue to the next iteration of the loop
            }
            if (animal.equals("horse")) {
                break; // break out of the loop
            }
            System.out.println("animal -> " + animal);
        }
    }
}
