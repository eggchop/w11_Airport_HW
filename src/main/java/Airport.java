import java.util.ArrayList;

public class Airport {

    private ArrayList<Hanger> hangers;
    private String airportCode;
    private ArrayList<Flight> flights;

    public Airport(String airportCode) {
        this.hangers = new ArrayList<>();
        this.airportCode = airportCode;
        this.flights = new ArrayList<>();
    }

    public int getHangersCount() {
        return hangers.size();
    }

    public void addHanger(Hanger hanger) {
        this.hangers.add(hanger);
    }

    public int getFlightCount() {
        return flights.size();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }


    public void createFlight(String flightNumber, String destination) {
        addFlight(new Flight(flightNumber, destination));
    }


    public Flight findFlightByFlightNo(String flightNumber) {
        Flight result = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                result = flight;
            }
        }
        return result;
    }

    public Plane findPlaneFromHangers(PlaneType planeType) {
        Plane result = null;
        for (Hanger hanger : hangers ) {
            Plane plane = hanger.findPlaneByType(planeType);
            if (plane != null){
                result = plane;
            }
        }
        return result;
    }

    public void addPlaneToFlight(PlaneType planeType, String flightNumber) {
        Plane foundPlane = findPlaneFromHangers(planeType);
        Flight flightFound = findFlightByFlightNo(flightNumber);
        flightFound.setPlane(foundPlane);
    }

    public void sellTicket(String flightNumber) {
        Flight flightFound = findFlightByFlightNo(flightNumber);
        if (flightFound.planeHasBeenAssignedToFlight()){
            if (flightFound.planeHasSpace()) {
                flightFound.addPassenger(new Passenger());
            }
        }
    }

    public int getPassengerCount(Flight flight1) {
        return flight1.getPassengerCount();
    }
}


