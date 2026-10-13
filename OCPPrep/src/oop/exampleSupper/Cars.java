package oop.exampleSupper;

public class Cars {

    boolean isAutomatic = false;

    public Cars() {
        System.out.println("Car constructor is called");
    }

    public Cars(String carName) {
        System.out.println("Car constructor is called with car name: " + carName);
    }

    public void accelerate() {
        System.out.println("Car is accelerating...");
    }
}
