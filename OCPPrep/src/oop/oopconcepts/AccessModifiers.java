package oop.oopconcepts;

import calculator.Calculator;

/**
 * Access modifiers are used to control the visibility of classes, methods, and variables.
 * <p>
 * There are four access modifiers:
 * <ul>
 *   <li>public - accessible everywhere</li>
 *   <li>protected - accessible within the same package and subclasses</li>
 *   <li>private - accessible only within the same class</li>
 *   <li>default - accessible only within the same package (no modifier)</li>
 * </ul>
 */
public class AccessModifiers {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.divide(1, 2); // Public method is accessible everywhere.
        // calculator.privateMethod(); // Private method is accessible only within the same class.
        // calculator.protectedMethod(); // Protected method is accessible within the same package and subclasses.
        // calculator.defaultMethod(); // Default method is accessible only within the same package.

        OOPConcepts oopConcepts = new OOPConcepts();
        oopConcepts.protectedMethod(); // Protected method is accessible within the same package and subclasses.
        // oopConcepts.privateMethod(); // Private method is accessible only within the same class.
        oopConcepts.defaultMethod(); // Default method is accessible only within the same package.
    }

    /**
     * Private access modifier is accessible only within the same class.
     */
    private void privateMethod() {
        System.out.println("privateMethod");
    }

    /**
     * Protected access modifier is accessible within the same package and subclasses.
     */
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    /**
     * Default access modifier is accessible only within the same package.
     */
    void defaultMethod() {
        System.out.println("defaultMethod");
    }

}
