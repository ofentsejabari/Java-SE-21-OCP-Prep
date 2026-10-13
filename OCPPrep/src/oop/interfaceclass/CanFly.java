package oop.interfaceclass;

public interface CanFly {

    void canFly();

    /**
     * Static and default methods in an interface are not abstract.
     * Static methods are used to define constants.
     * Default methods are used to define default implementation of the method.
     */
    default void canFlyDefault() {
        System.out.println("Bird is flying");
    }

}
