package oop.constructor;

public class MainTest {

    public static void main(String[] args) {
        Person person = new Person("John", 25);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        System.out.println(person);
        System.out.println(person.toString());

        Person person2 = new Person("Jane", 26);
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());

        System.out.println(person2);
        System.out.println(person2.toString());
    }
}