package oop.oopconcepts;

/**
 * Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code to manipulate that data.
 * <p>
 * The four main principles of OOP are:
 * <ul>
 *   <li>Encapsulation</li>
 *   <li>Inheritance</li>
 *   <li>Polymorphism</li>
 *   <li>Abstraction</li>
 * </ul>
 * <p>
 * Encapsulation is the process of wrapping code and data together into a single unit, and restricting access to some of the internal components of the object.
 * <p>
 * Inheritance is the process of creating a new class that inherits the properties and methods of an existing class.
 * <p>
 * Polymorphism is the ability of an object to take on many forms.
 * <p>
 * Abstraction is the process of hiding the complex details and showing only the necessary information to the user. 
 * 
 * Characteristics of an object:
 * <ul>
 *   <li>State</li>
 *   <li>Behavior</li>
 *   <li>Identity</li>
 * </ul>
 * <p>
 * State is the data that the object contains.
 * <p>
 * Behavior is the methods that the object can perform.
 * <p>
 * Identity is the unique identifier of the object.
 */

public class OOPConcepts {

    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    private void privateMethod() {
        System.out.println("privateMethod");
    }

    void defaultMethod() {
        System.out.println("defaultMethod");
    }

}
