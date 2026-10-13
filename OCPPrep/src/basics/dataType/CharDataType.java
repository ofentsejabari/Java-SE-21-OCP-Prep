package basics.dataType;

/**
 * Char data type is used to store a single character.
 * <ul>
 *   <li>{@code char} - 2 bytes - 16 bits - 0 to 65,535</li>
 * </ul>
 */
public class CharDataType {
    public static void main(String[] args) {
        char ch = 'A'; // 65 in decimal, 0100 0001 in binary
        System.out.println("ch -> " + ch); // A

        char ch2 = '!'; // 33 in decimal, 0010 0001 in binary, ! symbol in ASCII table
        System.out.println("ch2 -> " + ch2); // !
        System.out.println("ch2 is digit -> " + Character.isDigit(ch2)); // false


        char ch3 = 67; // 67 in decimal, 0100 0011 in binary, C symbol in ASCII table
        System.out.println("ch3 -> " + ch3); // C
        char ch4 = (char)(ch3+3); // 70 in decimal, 0100 0110 in binary, F symbol in ASCII table
        System.out.println("ch4 -> " + ch4); // F
        System.out.println("ch3 is letter -> " + Character.isLetter(ch3)); // true
        System.out.println("ch4 is letter -> " + Character.isLetter(ch4)); // true


        char ch5 = 70; // 70 in decimal, 0100 0110 in binary, F symbol in ASCII table
        char ch6 = ch5 --; // After this line sh6 is 69 in decimal, 0100 0101 in binary, E symbol in ASCII table
        boolean check1 = (ch6 == 'E');// F != E, so check1 is false
        boolean check2 = (ch5 > 'D'); // F(69) > D(68), so check2 is true

        System.out.println("check1 -> " + check1); // false
        System.out.println("check2 -> " + check2); // true
    }
}
