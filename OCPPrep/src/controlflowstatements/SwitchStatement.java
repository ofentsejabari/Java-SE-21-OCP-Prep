package controlflowstatements;

import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day number: ");
        int day = scanner.nextInt();
        scanner.close();
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println(dayName);

        // Alternative syntax for switch statement
        /**
         * Without break, Java does fall-through.
         * That means once one case matches, Java keeps running the next case blocks too, until it hits a break or the switch ends.
         */
        switch (day) {
            case 1: case 2: case 3: case 4: case 5: {
                if(day == 1) {
                    System.out.println("Monday");
                } else {
                    System.out.println("Other weekday");
                }
                break;
            }
            case 6: case 7: {
                System.out.println("Weekend");
                break;
            }
            default: System.out.println("Invalid day");
        } 
    }   
}
