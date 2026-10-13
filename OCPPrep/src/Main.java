//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int x = switch (args.length) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            default -> 0;
        };
        System.out.println(x);
    }
}