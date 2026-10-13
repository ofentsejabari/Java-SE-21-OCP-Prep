package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

List<String> names = new ArrayList<>(List.of("Stan", "Jane", "Ann", "Jill", "Jack"));
Collections.sort(names, (n1, n2) -> n1.compareTo(n2));


        List<Cars> cars = new ArrayList<>(List.of(
            new Cars("Toyota", 2028, 20000), 
        new Cars("Honda", 2021, 25000), 
        new Cars("Ford", 2025, 30000),
        new Cars("Chevrolet", 2027, 35000),
        new Cars("Nissan", 2023, 40000),
        new Cars("BMW", 2026, 45000),
        new Cars("Mercedes", 2024, 50000),
        new Cars("Audi", 2022, 55000),
        new Cars("Porsche", 2028, 60000),
        new Cars("Lamborghini", 2029, 65000),
        new Cars("Ferrari", 2000, 70000)));
        Collections.sort(cars, (c1, c2) -> c1.getPrice() - c2.getPrice());
        Collections.sort(cars, new CarsComparator());
        System.out.println(cars);  
        
        Collections.sort(cars, new Comparator<Cars>() {
            @Override
            public int compare(Cars o1, Cars o2) {
                return o1.getYear() - o2.getYear();
            }
        });
        System.out.println(cars);  
     }
}

class Cars{
    private String make;
    private int year;
    private int price;

    public Cars(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" + make + ", " + year + ", " + price + "}\n";
    }
}



class CarsComparator implements Comparator<Cars> {
    @Override
    public int compare(Cars o1, Cars o2) {
        return o1.getPrice() - o2.getPrice();
    }
}