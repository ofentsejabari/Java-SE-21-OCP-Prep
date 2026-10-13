package oop.constructor;

/**
 * Constructor is a special method that is used to initialize objects state.
 * <p>
 * It is called when an object of a class is created.
 * <p>
 * It is used to set initial values for object's instance variables.
 * <p>
 * It is used to perform initialization tasks.
 * <p>
 * It is used to perform validation of the object's state.
 */
public class Person {
    private String name;
    private int age;

    /**
     * Constructor for the Person class.
     * <p>
     * It is used to initialize the name and age of the person.
     * @param name - The name of the person.
     * @param age - The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", age=" + this.age + "]";
    }

}
