import java.util.ArrayList;

public class Plane {


    private PlaneType planeType;
    private Airline airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType planeType, Airline airline) {
        this.planeType = planeType;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getPlaneType(){
        return planeType;
    }

    public int getPlaneTypeCapacityFromEnum() {
        return planeType.getPlaneTypeCapacity();
    }

    public Airline getAirline() {
        return airline;
    }


    public int getNumberOfPassengers() {
        return passengers.size();
    }

//    public void addPassenger(Passenger passenger) {
//        passengers.add(passenger);
//    }


}
