package oop.anonymusclass;


/**
 * Anonymous class is a class that is declared and instantiated in one go.
 *  <ul>
 *      <li>It cannot access local variables in its enclosing scope that are not final or effectively final.</li>
 *      <li>It can access instance variables and static variables of the enclosing class.</li>
 *      <li>It can access the methods of the enclosing class.</li>
 *  </ul>
 */
public class AnonymasClassTest {

    public static void main(String[] args) {
        
        Animals animals = new Animals() {
            @Override
            public void show(String name, int age) {
                System.out.println("Name: " + name + " Age: " + age);
            }
        };
        animals.show("John", 25);
    }

}
