package furama_resort.model.facility;

import java.util.Objects;

public class House extends Facility {
    private String roomStandard;
    private int floorNum;


    public House(String code, String name, float area, long expense, int quantity, String rentalType, String roomStandard, int floorNum) {
        super(code, name, area, expense, quantity, rentalType);
        this.roomStandard = roomStandard;
        this.floorNum = floorNum;
    }

    public House() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
        House house = (House) o;
        return floorNum == house.floorNum && Objects.equals(roomStandard, house.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, floorNum);
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", floorNum=" + floorNum +
                '}';
    }
}
