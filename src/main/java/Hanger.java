import java.util.ArrayList;

public class Hanger {

    private ArrayList<Plane> planes;
    private int hangerNo;

    public Hanger(int hangerNo) {
        this.planes = new ArrayList<>();
        this.hangerNo = hangerNo;
    }

    public Plane removePlane(Plane plane) {
        int found = planes.indexOf(plane);
        return planes.remove(found);
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public int getPlaneCount() {
        return planes.size();
    }

    public int getHangerNo() {
        return hangerNo;
    }


    public Plane findPlaneByType(PlaneType planeType) {
        Plane result = null;
        for (Plane plane  : planes) {
            if (plane.getPlaneType() == planeType) {
                result = plane;
            }
        }
        planes.remove(result);
        return result;
    }

}
