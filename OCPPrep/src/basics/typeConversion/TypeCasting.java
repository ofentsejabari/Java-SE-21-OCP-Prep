package basics.typeConversion;

public class TypeCasting {
    public static void main(String[] args) {
        int intValue = 150;
        long longValue = intValue;
        double doubleValue = longValue;

        System.out.println("intValue: " + intValue);
        System.out.println("longValue: " + longValue);
        System.out.println("doubleValue: " + doubleValue);

        // converting  a large numbet to a smaller type will result in data loss
        long longValue2 = 10000000000L;
        int intValue2 = (int) longValue2;
        System.out.println("intValue2: " + intValue2);

        // converting a smaller type to a larger type will not result in data loss
        int intValue3 = 150;
        byte byteValue = (byte) intValue3;
        System.out.println("byteValue: " + byteValue);
 
    }

}
