package controlflowstatements;

/**
 * For each loop is a control flow statement that allows you to iterate over a collection of elements.
 * <ul>
 *   <li>{@code for} - keyword</li>
 *   <li>{@code int number : numbers} - initialization</li>
 *   <li>{@code number} - element</li>
 *   <li>{@code numbers} - collection</li>
 * </ul>
 */
public class ForEach {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for(int number : numbers) {
            System.out.println("number -> " + number);
        }

        // -- sum of all elements in the array
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        System.out.println("sum -> " + sum); 


        String movie = "The Dark Knight";
        for(char character : movie.toCharArray()) {
            System.out.println("character -> " + character);
        }
    }

}
