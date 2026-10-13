package oop.abstractKeyword;

public class Car extends Vehicle {

    public Car(String model, String type) {
        super(model, type);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_SPEED = 100;
        return MAX_SPEED;
    }

}
