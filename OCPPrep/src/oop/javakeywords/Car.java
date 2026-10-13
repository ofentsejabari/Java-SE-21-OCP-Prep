package oop.javakeywords;

public class Car {
    public static int currentSpeed = 0;
    public static int maxSpeed = 100;

    public static void printCurrentSpeed(int cSpeed) {
        System.out.println("Current speed: " + cSpeed);
    }

    public static void printMaxSpeed() {
        System.out.println("Max speed: " + maxSpeed);
    }

    public static void accelerate(int increaseSpeed) {
        currentSpeed += increaseSpeed;
        if(currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
            System.out.println("Max speed reached, please slow down");
        }
    }

    public static void decelerate(int decreaseSpeed) {
        currentSpeed -= decreaseSpeed;
        showCurrentSpeed();
    }

    public static void showCurrentSpeed() {
        System.out.println("Current speed: " + currentSpeed);
    }

    public static void brake() {
        currentSpeed = 0;
        showCurrentSpeed();
    }
}
