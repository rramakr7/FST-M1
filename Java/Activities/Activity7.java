package activities;

interface BicycleParts{
    public int gears = 0;
    public int currentSpeed = 0;
}
interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

class Bicycle implements BicycleOperations,BicycleParts{
    public int gears;
    public int currentSpeed;

    public Bicycle(int gears,int currentSpeed){
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int reduceSpeed){
        currentSpeed = currentSpeed - reduceSpeed;
    }
    public void speedUp(int increaseSpeed){
        currentSpeed = currentSpeed + increaseSpeed;
    }

    public void bicycleDesc(){
        System.out.println("No. of gears are " + gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle{
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int seatHeight){
        super(gears,currentSpeed);
        this.seatHeight = seatHeight;
    }
    public void setSeatHeight(int newSeatHeight){
        seatHeight = newSeatHeight;
    }
    public void bicycleDesc(){
        super.bicycleDesc();
        System.out.println("Seat Height is " + seatHeight);
    }

}
public class Activity7 {
    public static void main(String[] args){
        MountainBike mb = new MountainBike(2,60,15);
        mb.bicycleDesc();
        mb.speedUp(20);
        mb.applyBrake(10);
        mb.bicycleDesc();
    }
}
