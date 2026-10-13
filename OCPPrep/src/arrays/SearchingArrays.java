package arrays;

import java.util.Arrays;

public class SearchingArrays {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; // -- Sorted array --
        System.out.println("numbers: " + Arrays.toString(numbers));
        int index = Arrays.binarySearch(numbers, 30); // -- 30 is the value to search for
        System.out.println("index: " + index); // -- 2 is the index of 30


        /**
         * Arrays.binarySearch is only defined for a sorted array (yours is {10, 20, 30, 40, 50}). 
         * 35 is not in the array, so the method does not return an index of 35.
         * When the key is missing, the contract is:
         * return value = -(insertionPoint) - 1
         * insertionPoint is the index where you would insert 35 so the array stays ordered: the index of the 
         * first element greater than 35. That element is 40 at index 3.
         * So:
         * insertionPoint = 3
         * -(3) - 1 = -4
         */
        index = Arrays.binarySearch(numbers, 35); // -- 35 is not in the array
        System.out.println("index: " + index); // -- -4 is the index of the value 35

        // -- The result is unpredictable is the array is not sorted --
        int[] numbers2 = {10, 5, 300, 400, 50}; // -- Unsorted array --
        System.out.println("numbers2: " + Arrays.toString(numbers2));
        index = Arrays.binarySearch(numbers2, 50); // -- 50 is in the array
        System.out.println("index: " + index); // -- -3
    }

}
