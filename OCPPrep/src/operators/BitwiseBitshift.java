package operators;

/**
 * Bitwise and bitshift operators are operators that operate on the binary representation of numbers.
 * <ul>
 *   <li>{@code &} - Bitwise AND operator</li>
 *   <li>{@code |} - Bitwise OR operator</li>
 *   <li>{@code ^} - Bitwise XOR operator</li>
 *   <li>{@code ~} - Bitwise NOT/complement operator: Invert all bits in binary representation</li>
 *   <li>{@code <<} - Left shift operator</li>
 *   <li>{@code >>} - Right shift operator</li>
 * </ul>
 * Used on integer types (byte, short, int, long, char)
 */
public class BitwiseBitshift {
    public static void main(String[] args) {
        // Bitwise AND operator
        int a = 8; // 1000 in binary
        int b = 9; // 1001 in binary
        int c = a & b; // 1000 in binary

        System.out.println("a -> " + Integer.toBinaryString(a));
        System.out.println("b -> " + Integer.toBinaryString(b));

        System.out.println("a & b in decimal -> " + c); 
        System.out.println("a & b in binary -> " + Integer.toBinaryString(c));

        // Bitwise OR operator: If either bit is 1, result is 1, otherwise 0
        int d = a | b; // 1001 in binary
        System.out.println("a | b in decimal -> " + d);
        System.out.println("a | b in binary -> " + Integer.toBinaryString(d));

        // Bitwise XOR operator; If both bits are different, result is 1, otherwise 0
        int e = a ^ b; // 0001 in binary
        System.out.println("a ^ b in decimal -> " + e);
        System.out.println("a ^ b in binary -> " + Integer.toBinaryString(e));

        // Bitwise NOT operator; Invert all bits in binary representation. 
        int f = ~a; // 1000 -> 0111 in binary
        System.out.println("~a in decimal -> " + f);
        System.out.println("~a in binary -> " + Integer.toBinaryString(f));

        // Left shift operator: Shift bits to the left by the number of positions specified
        int g = a << 1; // 10000 in binary
        System.out.println("a << 1 in decimal -> " + g);
        System.out.println("a << 1 in binary -> " + Integer.toBinaryString(g));

        // Right shift operator: Shift bits to the right by the number of positions specified
        int h = a >> 1; // 0100 in binary
        System.out.println("a >> 1 in decimal -> " + h);
        System.out.println("a >> 1 in binary -> " + Integer.toBinaryString(h));
    }
}
