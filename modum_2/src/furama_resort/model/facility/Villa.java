package furama_resort.model.facility;

import java.util.Objects;

public class Villa extends Facility {
    private String roomStandard;
    private float poolArea;
    private int floorNum;

    public Villa(String roomStandard, float poolArea, int floorNum) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floorNum = floorNum;
    }

    public Villa(String code, String name, String area, float expense, int quantity, String rentalType, String roomStandard, float poolArea, int floorNum) {
        super(code, name, area, expense, quantity, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floorNum = floorNum;
    }

    public Villa() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return Float.compare(villa.poolArea, poolArea) == 0 && floorNum == villa.floorNum && Objects.equals(roomStandard, villa.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, poolArea, floorNum);
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floorNum=" + floorNum +
                '}';
    }
}
