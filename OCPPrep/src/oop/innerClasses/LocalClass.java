package oop.innerClasses;

/**
 * Local classes are classes declared inside a method, constructor, or block.
 * <p>
 * Their main purpose is to create a small helper type that is only relevant to that local scope.
 * <p>

 * Why use them
 * <ul>
 *   <li>Encapsulation of method-specific logic: keep one-off class behavior close to where it’s used.</li>
 *   <li>Reduce namespace clutter: the class is not visible outside that block/method.</li>
 *   <li>Access to surrounding context: they can use local variables (only if they are final or effectively final) and members of the enclosing class.</li>
 *   <li>Typical use case: When you need a slightly complex helper (more than a lambda), but that helper is only needed in one method.</li>
 * </ul>
 * <p>
 * So in short: local classes are for scoped, private helper types tied to a specific execution context.
 */
public class LocalClass {

    public static void main(String[] args) {
        checkNumber(10);
        checkNumber(11);
        checkNumber(12);
        checkNumber(13);
        checkNumber(14);
        checkNumber(15);
        checkNumber(16);
        checkNumber(17);
        checkNumber(18);
    }

    public static void checkNumber(int enteredNumber) {
        int result = 0; // effectively final - means that the value of the variable is not changed after it is initialized.
    
        // -- local class - declared inside a method, constructor, or block. They cannot have access modifiers.
        class NumberChecker {
            boolean check;
            // constructor
            public NumberChecker(int number) {
                check = number % 2==result?true:false;
            }
            // -- method to print the result
            public void printResult() {
                System.out.println("You entered: " + enteredNumber);
            }
        }

        NumberChecker numberChecker = new NumberChecker(enteredNumber);
        numberChecker.printResult();
        if(numberChecker.check) {
            System.out.println("The number is even");
        }else {
            System.out.println("The number is odd");
        }
    }

}
