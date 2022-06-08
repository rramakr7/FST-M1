package activities;

public class Activity1 {

    public static void main(String[] args){
        Car Creta = new Car();
        Creta.make = 2022;
        Creta.color = "Black";
        Creta.transmission = "Manual";

        Creta.displayCharacteristics();
        Creta.accelerate();
        Creta.brake();
    }
}
