package oop.interfaceclass;

public class Bird implements CanFly, CanFeed {

    @Override
    public void canFly() {
        System.out.println("Bird is flying");
    }

    @Override
    public void canEat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void canDrink() {
        System.out.println("Bird is drinking");
    }

}