public enum PlaneType {

    AIRBUS_BIG(4),
    AIRBUS_SMALL(1),
    BOEING_BIG(4),
    BOEING_SMALL(2);

    private final int value;
    PlaneType(int value){
        this.value = value;
    }

    public int getPlaneTypeCapacity(){
        return value;
    }
}
