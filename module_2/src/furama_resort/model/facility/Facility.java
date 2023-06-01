package furama_resort.model.facility;

import java.util.Objects;

public abstract class Facility {
    private String code;
    private String name;
    private String area;
    private float expense;
    private int quantity;
    private String rentalType;

    public Facility() {
    }

    public Facility(String code, String name, String area, float expense, int quantity, String rentalType) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.expense = expense;
        this.quantity = quantity;
        this.rentalType = rentalType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Float.compare(facility.expense, expense) == 0 && quantity == facility.quantity && Objects.equals(code, facility.code) && Objects.equals(name, facility.name) && Objects.equals(area, facility.area) && Objects.equals(rentalType, facility.rentalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, area, expense, quantity, rentalType);
    }

    @Override
    public String toString() {
        return "Facility{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", expense=" + expense +
                ", quantity=" + quantity +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
