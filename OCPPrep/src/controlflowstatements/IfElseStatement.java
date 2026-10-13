package controlflowstatements;

import java.util.Scanner;

public class IfElseStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("You are an adult");
        } else {
            System.out.println("You are not an adult");
        }
        scanner.close();
    }

}
