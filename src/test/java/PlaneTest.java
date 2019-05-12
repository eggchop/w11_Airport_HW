import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;
    PlaneType planeType;
    Airline airline;
    Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(planeType.BOEING_SMALL, airline.BRITISH_AIRWAYS);
        passenger = new Passenger();
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(planeType.BOEING_SMALL, plane.getPlaneType());
    }

    @Test
    public void checkPlaneAirline(){
        assertEquals(airline.BRITISH_AIRWAYS, plane.getAirline());
    }

//    @Test
//    public void checkNumberOfPassengersStartsZero(){
//        assertEquals(0, plane.getNumberOfPassengers());
//    }

    @Test
    public void checkCapactiyOfPlaneType(){
        assertEquals(2, plane.getPlaneTypeCapacityFromEnum());
    }

//    @Test
//    public void checkCanAddPassengerToPlane(){
//        plane.addPassenger(passenger);
//        assertEquals(1, plane.getNumberOfPassengers());
//
//    }




}
