package oop.javakeywords;

import static java.lang.Math.max;
import static java.lang.Math.pow;

/** 
 * Static keyword is used to declare a static member of a class.
 * <p>
 * Static members are shared by all instances of the class.
 * <p>
 * Static members are initialized before the first object of the class is created.
 * <p>
 * Static members are accessed using the class name.
 * <p>
 * Static members are not associated with any specific object.
 */
public class TestStaticKeyword {

    public static void main(String[] args) {
        Car.printCurrentSpeed(Car.currentSpeed);
        Car.printMaxSpeed();
        Car.accelerate(1000);
        Car.decelerate(5);
        Car.showCurrentSpeed();
        Car.brake();

        int max = max(10, 20);
        System.out.println("max: " + max);
        double min = pow(2, 2);
        System.out.println("min: " + min);
    }

}
