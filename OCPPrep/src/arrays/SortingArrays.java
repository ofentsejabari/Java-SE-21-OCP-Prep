package arrays;

import java.util.Arrays;

public class SortingArrays {    
    public static void main(String[] args) {
        double[] numbers = {5.5, 2.2, 8.8, 1.1, -4.4, 3.3};
        System.out.println("Unsorted numbers: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));

        // -- The default sorting order is ascending order  and the upper case letters are sorted before the lower case letters--
        String[] names = {"amogelang", "Jane", "Jim", "Amber", "Jack"};
        System.out.println("Unsorted names: " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("Sorted names: " + Arrays.toString(names));

        char[] characters = {'a', 'B', 'c', 'd', 65};
        System.out.println("Unsorted characters: " + Arrays.toString(characters));
        Arrays.sort(characters);
        System.out.println("Sorted characters: " + Arrays.toString(characters));

        String[] numbers2 = {"10", "2", "100", "40", "5"}; // -- 10 100 2 40 5
        System.out.println("Unsorted numbers2: " + Arrays.toString(numbers));
        Arrays.sort(numbers2);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers2));

        String[] mixedStrings = {"10", "2", "100", "40", "5", "A", "bravo", "charlie", "Delta"}; // 10, 100, 2, 40, 5, A, Delta, bravo, charlie
        System.out.println("UnmixedStrings: " + Arrays.toString(mixedStrings));
        Arrays.sort(mixedStrings);
        System.out.println("Sorted mixedStrings: " + Arrays.toString(mixedStrings));
    }

}
