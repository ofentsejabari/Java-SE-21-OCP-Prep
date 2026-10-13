package controlflowstatements;

public class TernaryOperator {
    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        int result = (a > b) ? a : b;
        System.out.println("result -> " + result);


        int x = 10, y = 9;
        int result2 = (x == y) ? x++ : y--;
        System.out.println("x -> " + x);// 10
        System.out.println("y -> " + y); // 8

        System.out.println("result2 -> " + result2); //9

    }

}
