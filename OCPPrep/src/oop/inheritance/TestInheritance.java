package oop.inheritance;

public class TestInheritance {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.drink("Dog");
        dog.move("Dog");
        dog.breath("Dog");

        dog.numberOfLegs = 4;
        dog.printNumberOfLegs();

        Bird bird = new Bird();
        bird.fly();
        bird.drink("Bird");
        bird.move("Bird");
        bird.breath("Bird");

        bird.numberOfLegs = 2;
        bird.printNumberOfLegs();
    }
}
