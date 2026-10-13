package oop.NestedClasses;

import oop.NestedClasses.Person.PersonBuilder;

public class TestNestedClass {

        public static void main(String[] args) {

            PersonBuilder personBuilder = new Person.PersonBuilder();
            personBuilder.buildPerson();

            Person person = new Person(); //-- 
            System.out.println("Address: " + person.address);
        }

}
