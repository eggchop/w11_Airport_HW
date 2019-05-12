import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Hanger hanger, hanger2;
    Airport airport;
    Flight flight1, flight2;
    Plane plane;
    PlaneType planeType;
    Airline airline;

    @Before
    public void before(){
        airport = new Airport("Edinburgh");
        hanger = new Hanger(1);
        hanger2 = new Hanger(2);
        flight1 = new Flight( "BA60778", "PARIS");
        flight2 = new Flight( "QA9832L", "SYDNEY");
        plane = new Plane(planeType.BOEING_SMALL, airline.BRITISH_AIRWAYS);

    }

    @Test
    public void checkCanAddFlightToAirport(){
        airport.addFlight(flight1);
        assertEquals(1, airport.getFlightCount());
    }

    @Test
    public void checkCreateFlight() {
        airport.createFlight("BA892383", "LONDON");
        assertEquals(1, airport.getFlightCount());
    }

    @Test
    public void checkCanAddHangers(){
        airport.addHanger(hanger);
        airport.addHanger(hanger2);
        assertEquals(2, airport.getHangersCount());
    }

    @Test
    public void checkCanFindFlightByFlightNo(){
        airport.addFlight(flight1);
        Flight flightFound = airport.findFlightByFlightNo("BA60778");
        assertEquals(flight1, flightFound);

    }

    @Test
    public void checkCanFindPlaneFromHangers(){
        airport.addHanger(hanger);
        airport.addHanger(hanger2);
        hanger2.addPlane(plane);
        Plane planeFound = airport.findPlaneFromHangers(planeType.BOEING_SMALL);
        assertEquals(plane, planeFound);
    }

    @Test
    public void checkCanAssignPlaneToFlight(){
        airport.addHanger(hanger);
        airport.addHanger(hanger2);
        airport.addFlight(flight1);
        hanger2.addPlane(plane);
        airport.addPlaneToFlight(planeType.BOEING_SMALL,"BA60778" );
        assertEquals(0, hanger2.getPlaneCount());
        assertEquals(plane, flight1.getPlane());
        assertEquals(1, airport.getFlightCount());

    }

    @Test
    public void checkSellTicketToPassenger(){
        airport.addFlight(flight1);
        flight1.setPlane(plane);
        airport.sellTicket("BA60778");
        assertEquals(1, flight1.getPassengerCount());
    }

    @Test
    public void checkSellTicketToPassengerWithNoFlightAssigned(){
        airport.addFlight(flight1);
        airport.sellTicket("BA60778");
        assertEquals(0, flight1.getPassengerCount());
    }


    @Test
    public void checkAirportCanGetPassengerCountForFlights(){
        airport.addFlight(flight1);
        flight1.setPlane(plane);
        airport.sellTicket("BA60778");
        int passengerCount = airport.getPassengerCount(flight1);
        assertEquals(1, passengerCount);

    }

    @Test
    public void checkTicketsSoldCantExceedPlaneLimit(){
        airport.addFlight(flight1);
        flight1.setPlane(plane);
        airport.sellTicket("BA60778");
        airport.sellTicket("BA60778");
        airport.sellTicket("BA60778");
        airport.sellTicket("BA60778");
        int passengerCount = airport.getPassengerCount(flight1);
        assertEquals(2, passengerCount);
    }


}