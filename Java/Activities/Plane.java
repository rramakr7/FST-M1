package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;

    public Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    public void onboard(String passenger){
        this.passengers.add(passenger);

    }
    public Date takeOff(){
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public Date land(){
        this.lastTimeLanded = new Date();
        return lastTimeLanded;
    }
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    public List<String> getPassengers(){
        return passengers;
    }
}
