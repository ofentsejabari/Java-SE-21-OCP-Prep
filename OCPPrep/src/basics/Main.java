package basics;

public class Main {
    public static void main(String[] args) {

        /*
         * OCP note:
         * - {@code System} is a final utility class in {@code java.lang}.
         * - {@code out} is a static field of type {@code java.io.PrintStream}.
         * - So this is field access + instance method call:
         *     {@code System.out.println(...)}
         *   (println itself is NOT static).
         */
        System.out.println("Hello and welcome!");

        /*
         * OCP note: common System.out print methods
         * - print(x): prints without newline
         * - println(x): prints and appends line separator
         * - printf(format, args) and format(format, args): same behavior
         *   (both return PrintStream for chaining)
         *
         * Format syntax: %[argument_index$][flags][width][.precision]conversion
         *
         * Most tested conversions:
         * - %s String
         * - %d integer
         * - %f floating-point (default 6 decimals)
         * - %c character
         * - %b boolean
         * - %n platform-independent newline
         * - %% literal percent sign
         *
         * Useful flags/examples:
         * - %10s  right align in width 10
         * - %-10s left align in width 10
         * - %04d  pad integer with leading zeros
         * - %.2f  floating-point with 2 decimals
         * - %,d   grouping separator (e.g., 12,345)
         */

        // print vs println
        System.out.print("Java ");
        System.out.println("OCP");

        // printf / format examples
        System.out.printf("Hello and welcome!%n");
        System.out.printf("Name: %s, Score: %d, GPA: %.2f%n", "Ava", 95, 3.678);
        System.out.format("|%10s|%-10s|%04d|%,d|%n", "right", "left", 7, 12345);

        for (int i = 1; i <= 5; i++) {
            System.out.printf("i = %d%n", i);
        }
    }
}
