package arrays;

import java.util.Arrays;

/**
 * Arrays in Java are fixed-size containers that store multiple values of the same type.
 * <ul>
 *   <li>Arrays are indexed starting from 0.</li>
 *   <li>Arrays are of fixed size.</li>
 *   <li>Arrays are of homogeneous type.</li>
 *   <li>Arrays are of contiguous memory location.</li>
 * </ul>
 * <p>
 * Arrays are declared and initialized as follows:
 * <pre>
 * int[] numbers;
 * numbers = new int[5];
 * </pre>
 * <p>
 * Arrays can be declared and initialized in a single statement as follows:
 * <pre>
 * int[] numbers = {1, 2, 3, 4, 5};
 * </pre>
 */
public class Array {
    public static void main(String[] args) {
         // -- Declaration
        int[] numbers;

        // -- Initialization --
        numbers = new int[5]; // -- After initialization, numbers is an array of 5 integers with default value 0

        System.out.println("numbers[0] -> " + numbers[0]);
        System.out.println("numbers[1] -> " + numbers[1]);

        // -- Declaration and Initialization --
        int numbers2[] = {1, 2, 3, 4, 5}; //is equivalent to int[] numbers2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("numbers2[0] -> " + numbers2[0]);
        System.out.println("numbers2[1] -> " + numbers2[1]);

        System.out.println("numbers2.length -> " + numbers2.length);
        System.out.println("Number Array -> " + Arrays.toString(numbers2));


        String[] names = new String[5];
        names[0] = "John";
        names[1] = "Jane";
        names[2] = "Jim";
        names[4] = "Jack";

        System.out.println("names -> " + Arrays.toString(names));

        Object[] objects = new Object[5];
        objects[0] = "John";
        objects[1] = 25;
        objects[2] = 1.75;
        objects[3] = true;
        objects[4] = 'A';

        System.out.println("objects -> " + Arrays.toString(objects));
        
    }

}
