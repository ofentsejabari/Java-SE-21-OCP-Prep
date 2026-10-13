package operators;

public class ArithmaticOperator {
    public static void main(String[] args) {
        double pi = 3.14;
        double radius = 10;
        double area = pi * radius * radius;
        System.out.println(area);

        double circumference = 2 * pi * radius;
        System.out.println("2 * 3.14 * 10 = " + circumference);

        double diameter = 2 * radius;
        System.out.println("2 * 10 = " + diameter);

        // Division of integers results in an integer
        int a = 10;
        int b = 3;
        int c = a / b;
        System.out.println("10 / 3 = " + c);

        // Division of doubles results in a double
        double d = 10.0;
        double e = 3.0;
        double f = d / e;
        System.out.println("10.0 / 3.0 = " + String.format("%.2f", f));

        // Modulus of integers results in an integer
        int g = 10;
        int h = 3;
        int i = g % h;
        System.out.println("10 % 3 = " + i);

        // Modulus of doubles results in a double
        double j = 10.0;
        double k = 3.0;
        double l = j % k;
        System.out.println("10.0 % 3.0 = " + l);

        // Modulus of integers results in an integer
        
    }

}
