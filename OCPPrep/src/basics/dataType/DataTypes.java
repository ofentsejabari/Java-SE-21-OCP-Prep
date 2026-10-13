package basics.dataType;

/*
 * OCP notes: Data types in Java.
 *
 * <p>Data types are the types of data that can be stored in a variable.
 *
 * <p>Primitive data types:
 * <ul>
 *   <li>{@code byte}  - 1 byte - 8 bits - -128 to 127</li>
 *   <li>{@code short} - 2 bytes - 16 bits - -32,768 to 32,767</li>
 *   <li>{@code int} - 4 bytes - 32 bits - -2,147,483,648 to 2,147,483,647</li>
 *   <li>{@code long} - 8 bytes - 64 bits - -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807</li>
 *   <li>{@code float} - 4 bytes - 32 bits - 1.40129846432481707e-45 to 3.40282346638528860e+38</li>
 *   <li>{@code double} - 8 bytes - 64 bits - 4.94065645841246544e-324 to 1.79769313486231570e+308</li>
 *   <li>{@code char} - 2 bytes - 16 bits - 0 to 65,535</li>
 *   <li>{@code boolean}</li>
 * </ul>
 * Primitive data stores single values like numbers, characters, and booleans and are stored on the stack.
 *
 * <p>Reference data types:
 * <ul>
 *   <li>{@code String}</li>
 *   <li>{@code arrays}</li>
 *   <li>{@code class types}</li>
 *   <li>{@code enum types}</li>
 *   <li>{@code interface types}</li>
 *   <li>{@code annotation types}</li>
 *   <li>{@code record types}</li>
 *   <li>{@code lambda types}</li>
 *   <li>{@code stream types}</li>
 *   <li>{@code optional types}</li>
 *   <li>{@code supplier types}</li>
 * </ul>
 */
public class DataTypes {
    public static void main(String[] args) {
        /**
         * Primitive data types:
         */
        boolean isStudent = true;
        char grade = 'A';
        byte age = 25; // value range -128 to 127
        short height = 175; // value range -32,768 to 32,767
        int salary = 50000; // value range -2,147,483,648 to 2,147,483,647
        long distance = 1000000000; // value range -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float pi1 = 3.14f; // value range 1.40129846432481707e-45 to 3.40282346638528860e+38
        double pi = 3.14; // value range 4.94065645841246544e-324 to 1.79769313486231570e+308
        String name = "John";

        System.out.println("isStudent: " + isStudent);
        System.out.println("grade: " + grade);
        System.out.println("age: " + age);
        System.out.println("height: " + height);
        System.out.println("salary: " + salary);
        System.out.println("distance: " + distance);
        System.out.println("pi1: " + pi1);
        System.out.println("pi: " + pi);
        System.out.println("name: " + name);

        // String is a reference data type and is stored on the heap. String values are immutable. i.e. cannot be changed after creation.
        String name2 = "John";
        System.out.println("name2: " + name2);

        /*
        *<b>_</b> is used to improve readability of numbers.
        *<b>L</b> and <b>l</b> are used to indicate that the number is a long. <b>L</b> is used for long and <b>l</b> is used for float.
         */
    
        long money = 98_765_432_198L;
        System.out.println("money: " + money);

        float pi2 = 3.1_4f;
        System.out.println("pi2: " + pi2);
    }

}
