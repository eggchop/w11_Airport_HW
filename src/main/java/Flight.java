import java.util.ArrayList;

public class Flight {

    private ArrayList<Plane> plane;
    private String flightNumber;
    private String destination;
    private ArrayList<Passenger> passengerList;

    public Flight(String flightNumber, String destination){
        this.plane = new ArrayList<>();
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.passengerList = new ArrayList<>();
    }

    public Plane getPlane() {
            return plane.get(0);
    }

    public void setPlane(Plane plane) {
        if (this.plane.size() == 0) {
            this.plane.add(plane);
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getPassengerCount(){
        return passengerList.size();
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public boolean planeHasSpace(){
        Plane planeVariable = getPlane();
        return planeVariable.getPlaneTypeCapacityFromEnum() > getPassengerCount();


    }

    public boolean planeHasBeenAssignedToFlight(){
        return plane.size() == 1;

    }

}
