import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger;
    PlaneType planeType;
    Airline airline;

    @Before
    public void before(){
        plane = new Plane(planeType.BOEING_SMALL, airline.BRITISH_AIRWAYS);
        passenger = new Passenger();
        flight = new Flight( "BA60778", "PARIS");
    }

    @Test
    public void checkPlaneAssignedToFlight(){
        flight.setPlane(plane);
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void checkPlaneHasSpace(){
        flight.setPlane(plane);
        flight.addPassenger(passenger);
        assertEquals(true, flight.planeHasSpace());
    }

    @Test
    public void checkFlightKnowsPlaneFull(){
        flight.setPlane(plane);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals(false, flight.planeHasSpace());
    }

    @Test
    public void checkFlightHasNotBeenAssigned(){
        assertEquals(false, flight.planeHasBeenAssignedToFlight());
    }

    @Test
    public void checkFlightHasBeenAssigned(){
        flight.setPlane(plane);
        assertEquals(true, flight.planeHasBeenAssignedToFlight());
    }


}
