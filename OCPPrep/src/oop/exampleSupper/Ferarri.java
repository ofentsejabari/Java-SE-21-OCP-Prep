package oop.exampleSupper;

public class Ferarri extends Cars {
boolean isAutomatic = true;

public Ferarri() {
    super();
    System.out.println("Ferarri constructor is called");
}

public void printGrear() {
    System.out.println("Current gear: " + isAutomatic);
    System.out.println("Default gear: " + super.isAutomatic);
}

@Override
public void accelerate() {
    System.out.println("Ferarri is accelerating at 100 km/h");
}

public void speed() {
    System.out.println("Ferarri is speeding at 200 km/h");
}

public void dispaly() {
    super.accelerate();
    this.accelerate();
    speed();
} 

}
