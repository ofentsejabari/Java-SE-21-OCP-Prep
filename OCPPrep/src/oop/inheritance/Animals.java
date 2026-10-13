package oop.inheritance;

public class Animals {


    int numberOfLegs;

    public void printNumberOfLegs() {
        System.out.println("Number of legs: " + numberOfLegs);
    }

    public void eat(String animalName) {
        System.out.println(animalName + " is eating");
    }

    protected void drink(String animalName) {
        System.out.println(animalName + " is drinking");
    }

    void move(String animalName) {
        System.out.println(animalName + " is moving");
    }
    public void breath(String animalName) {
        System.out.println(animalName + " is breathing");
    }
}
