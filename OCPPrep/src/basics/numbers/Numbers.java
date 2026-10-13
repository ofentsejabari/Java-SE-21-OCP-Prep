package basics.numbers;

/**
 * Decimal, binary, octal, and hexadecimal numbers in Java.
 *
 * <p>Decimal numbers are the numbers we use in everyday life.
 * <p>Binary numbers are the numbers that are used in computers. They are represented as 0s and 1s.
 * <p>Octal numbers are the numbers that are used in computers. They are represented as 0-7.
 * <p>Hexadecimal numbers are the numbers that are used in computers. They are represented as 0-9 and A-F.
 */ 
public class Numbers {
    public static void main(String[] args) {
        /*
        * Write code to print the decimal, binary, octal, and hexadecimal numbers of 10
        */

        int hexNumber = 0x1b0; // 432 in decimal (0x1b0 = 1 * 16^2 + 11 * 16^1 + 0 * 16^0 = 432)
        int hexNumber2 = 0xFA; // 250 in decimal (0xFA = 15 * 16^1 + 10 * 16^0 = 250)

        System.out.println("hexNumber: " + hexNumber);
        System.out.println("hexNumber2: " + hexNumber2);

        int binaryNumber = 0b1010; // 10 in decimal (0b1010 = 1 * 2^3 + 0 * 2^2 + 1 * 2^1 + 0 * 2^0 = 10)
        int binaryNumber2 = 0B1001; // 9 in decimal (0B1001 = 1 * 2^3 + 0 * 2^2 + 0 * 2^1 + 1 * 2^0 = 9)

        /**
         * Showing addition of binary numbers with explanation
         * <pre>
         * 1010
         * 1001
         * ------
         * 10011    
         * 
         * 10011 in binary is 19 in decimal
         * 
         * </pre>
         */
        int binarySum = binaryNumber + binaryNumber2; // 19 in decimal

        System.out.println("binarySum: " + binarySum);
        System.out.println("binarySum in binary: " + Integer.toBinaryString(binarySum));
        System.out.println("binaryNumber: " + binaryNumber);
        System.out.println("binaryNumber2: " + binaryNumber2);
        
        int octalNumber = 012; // 10 in decimal
        int octalNumber2 = 017; // 15 in decimal

        System.out.println("octalNumber: " + octalNumber);
        System.out.println("octalNumber2: " + octalNumber2);

        int decimalNumber = 10; // 10 in decimal
        int decimalNumber2 = 18; // 18 in decimal

        System.out.println("decimalNumber: " + decimalNumber);
        System.out.println("decimalNumber2: " + decimalNumber2);
    }
}
