package oop.abstractKeyword;

/**
 * Abstract class is a class that is declared but not implemented.
 * It is declared with the abstract keyword.
 * It can have abstract methods and non-abstract methods.
 * It cannot be instantiated.
 * It can have constructors.
 * It can have static methods.
 * It can have final methods.
 * It can have private methods.
 * 
 * If a class contains an abstract method, the class must be declared as abstract.
 */
public abstract class Vehicle {

    String model;
    String type;

    public Vehicle(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public void start() {
        System.out.println("Vehicle is starting");
    }
    public void stop() {
        System.out.println("Vehicle is stopping");
    }   

   // abstract method
   /*
    * Abstract method is a method that is declared but not implemented in the abstract class.
    * It is declared in the abstract class and implemented in the subclass. 
    * This method cannot be private/final/static, only publi, protected and default are allowed.
    */
    abstract int getMaxSpeed();
   

}
