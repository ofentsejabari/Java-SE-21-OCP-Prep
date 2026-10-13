package oop.NestedClasses;

public class Person {

    static String name = "John";
    private static int age = 20;
    public String address = "123 Main St";

    public static class PersonBuilder {

        public void buildPerson() {
            System.out.println("Building person with name: " + name + " and age: " + age);

            // static nested class can access static members of the outer class because it is not associated with any instance of the outer class
            // System.out.println("Building person with address: " + address);

            Person person = new Person();
            System.out.println("Address: " + person.address);
        }
    }

}
