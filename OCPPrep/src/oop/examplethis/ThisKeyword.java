package oop.examplethis;

import java.util.Objects;

/**
 * This keyword is used to refer to the current object.
 * <p>
 * It can be used to refer to the current object's instance variables.
 * <p>
 * It can be used to refer to the current object's methods.
 * <p>
 * It can be used to refer to the current object's constructor.
 */
public class ThisKeyword {
    String car;
    int year;

    public ThisKeyword() {
        this("Toyota", 2020); // This calls the constructor with the arguments "Toyota" and 2020.
    }

    public ThisKeyword(String car, int year) {
        this.car = car;
        this.year = year;
    }

    private void printCarAndYear() {
        System.out.println("Car: " + car + " Year: " + year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ThisKeyword other = (ThisKeyword) obj;
        return Objects.equals(this.car, other.car) && this.year == other.year;
    }

    public static void main(String[] args) {
        ThisKeyword thisKeyword = new ThisKeyword("Toyota", 2020);
        System.out.println(thisKeyword.car);
        System.out.println(thisKeyword.year);

        thisKeyword.printCarAndYear();

        System.out.println(thisKeyword);

        ThisKeyword thisKeyword2 = new ThisKeyword("Toyota", 2020);

        System.out.println(thisKeyword2);

        System.out.println(thisKeyword.equals(thisKeyword2));
    }

}
