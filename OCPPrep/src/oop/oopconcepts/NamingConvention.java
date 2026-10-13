package oop.oopconcepts;

/**
 * Naming conventions are used to make the code more readable and maintainable.
 * <p>
 * There are some naming conventions for classes, methods, and variables.
 * <ul>
 *   <li>Classes: PascalCase</li>
 *   <li>Methods: camelCase</li>
 *   <li>Variables: camelCase</li>
 * </ul>
 * <p>
 * PascalCase is used for classes.
 * <p>
 * camelCase is used for methods and variables.
 * <p>
 * snake_case is used for constants.
 * <p>
 * Kebab-case is used for file names.
 * 
 * Example:
 * <pre>
 * public class MyClass {
 *   public void myMethod() {
 *     System.out.println("Hello, World!");
 *   }
 * }
 * </pre>
 * $ and _ and small letters are valid characters for class names.
 */
public class NamingConvention {
    public static void main(String[] args) {
        // -- Valid local variable names:
        int myVariable; // valid
        int _myVariable1; // valid
        int $myVariable2; // valid
        int myVariable$; // valid
        int myVariable_; // valid
        int _$$myVariable$; // valid

        // -- Invalid local variable names:
        int 1myVariable; // invalid - Cannot start with a number
        int myVariable 1; // invalid - Cannot contain spaces
        int myVariable!; // invalid - Cannot contain special characters
        int myVariable@; // invalid - Cannot contain special characters
        int myVariable#; // invalid - Cannot contain special characters
        int myVariable%; // invalid - Cannot contain special characters
        int myVariable^; // invalid - Cannot contain special characters
        int $myVariable&; // invalid - Cannot contain special characters


    }
}
