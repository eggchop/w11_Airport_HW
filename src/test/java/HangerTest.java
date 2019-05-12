import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangerTest {

    Hanger hanger;
    Plane plane1, plane2;
    PlaneType planeType;
    Airline airline;

    @Before
    public void before(){
        plane1 = new Plane(planeType.BOEING_SMALL, airline.BRITISH_AIRWAYS);
        plane2 = new Plane(planeType.AIRBUS_BIG, airline.BRITISH_AIRWAYS);
        hanger = new Hanger(1);
    }

    @Test
    public void checkPlaneAddedHanger(){
        hanger.addPlane(plane1);
        assertEquals(1, hanger.getPlaneCount());
    }

    @Test
    public void checkRemovePlaneHanger(){
        hanger.addPlane(plane2);
        Plane removedPlane = hanger.removePlane(plane2);
        assertEquals(0,hanger.getPlaneCount());
        assertEquals(plane2, removedPlane);
    }

    @Test
    public void checkFindPlaneByType(){
        hanger.addPlane(plane2);
        hanger.addPlane(plane1);
        Plane planeFound = hanger.findPlaneByType(planeType.AIRBUS_BIG);
        assertEquals(plane2, planeFound);
    }




}
