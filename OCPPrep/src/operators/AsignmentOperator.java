package operators;

public class AsignmentOperator {
    public static void main(String[] args) {
       
        int x = 10;
        int y = 20;
        int z = 0;

        z = x + y;
        System.out.println("z = x + y -> " + z);

        z += x; // z = z + x
        System.out.println("z += x -> " + z);

        z -= x; // z = z - x
        System.out.println("z -= x -> " + z);

        z *= x; // z = z * x
        System.out.println("z *= x -> " + z);

        z /= x; // z = z / x
        System.out.println("z /= x -> " + z);
        
        z %= x; // z = z % x
        System.out.println("z %= x -> " + z);

    }

}
