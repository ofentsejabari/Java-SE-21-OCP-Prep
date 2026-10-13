package oop.oopconcepts;

/**
 * Stack and Heap are the two main memory areas in Java.
 * <p>
 * Stack is the memory area for local variables and Primitive data types and references to objects. It is a LIFO (Last In First Out) data structure.
 * <p>
 * Heap is the memory area for objects, instances variables and arrays/ References types. Does not adhere to a specific order.
 */

public class StackHeapMemory {

    public static void main(String[] args) {
        int x = 1;              // x on stack
        String s = "hello";     // reference s on stack; String object on heap (often interned for literals)
        int[] a = {1, 2, 3};    // reference a on stack; array object on heap
    }

}
