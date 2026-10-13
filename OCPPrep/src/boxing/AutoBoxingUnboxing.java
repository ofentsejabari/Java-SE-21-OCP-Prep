package boxing;

/**
 * Auto-boxing is the process of converting a primitive type to its corresponding wrapper class object.
 * Auto-unboxing is the process of converting a wrapper class object to its corresponding primitive type.
 */

public class AutoBoxingUnboxing {

    public static void main(String[] args) {

        int intValue = 10;
        Integer integerValue = intValue; // Auto-boxing
        System.out.println("integerValue -> " + integerValue);

        int intValue2 = integerValue; // Auto-unboxing
        System.out.println("intValue2 -> " + intValue2);
    }

}
