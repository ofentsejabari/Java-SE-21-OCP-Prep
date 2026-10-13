package arrays;

import java.util.Arrays;

public class MultidimentionalArray {
    public static void main(String[] args) {

        /**
         * A jagged array is a multidimensional array where rows can have different lengths.
         * In Java, int[][] is actually “array of int[]”, so each row is a separate array and can be a different size.
         */
        int[][] numbers = {
            {1, 2, 3}, // -- 1st row --
            {4, 5, 6, 10}, // -- 2nd row --
            {7, 8} // -- 3rd row --
        };
        System.out.println("numbers: " + Arrays.deepToString(numbers));

        System.out.println("----------------------------------------------");

        // -- 2D array declaration and initialization: “rectangular-like” array where all rows have same length--
        int[] numbers2[] = new int[3][4]; // -- 3 rows and 4 columns --
        // -- 1st 1 D array --
        numbers2[0][0] = 1;
        numbers2[0][1] = 2;
        numbers2[0][2] = 3;
        // -- 2nd 1 D array --
        numbers2[1][0] = 4;
        numbers2[1][1] = 5;
        numbers2[1][2] = 6;
        // numbers2[1][3] = 7;

        // -- 3rd 1 D array --
        numbers2[2][0] = 8;
        numbers2[2][1] = 9;
        numbers2[2][2] = 10;
        // numbers2[2][3] = 11;
        System.out.println("numbers2: " + Arrays.deepToString(numbers2));


        System.out.println("----------------------------------------------");

        char[][] letters[] = {
            {// -- 1st 2D array --
                {'a', 'b', 'c'}, // -- 1st 1D array of the 1st 2D array --
                {'d', 'e'},
            },
            {// -- 2nd 2D array --
                {'j'}, // -- 1st 1D array of the 2nd 2D array --
                {'m', 'n'},
                {'p', 'q', 'r'},
            },
        };
        System.out.println("letters: " + Arrays.deepToString(letters));

        System.out.println(Arrays.toString(letters[0][0]));
        System.out.println(Arrays.toString(letters[0][1]));
        System.out.println(Arrays.toString(letters[1][0]));
        System.out.println(Arrays.toString(letters[1][1]));
        System.out.println(Arrays.toString(letters[1][2]));
    }

}
