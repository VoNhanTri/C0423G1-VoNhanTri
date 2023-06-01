package furama_resort.model;

import java.util.Objects;

public class Booking {
    private String codeBooking;
    private String dateBooking;
    private String startDay;
    private String endDate;
    private String codeCustomer;
    private String codeService;

    public Booking(String codeBooking, String dateBooking, String startDay, String endDate, String codeCustomer, String codeService) {
        this.codeBooking = codeBooking;
        this.dateBooking = dateBooking;
        this.startDay = startDay;
        this.endDate = endDate;
        this.codeCustomer = codeCustomer;
        this.codeService = codeService;
    }

    public Booking() {
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(codeBooking, booking.codeBooking) && Objects.equals(dateBooking, booking.dateBooking) && Objects.equals(startDay, booking.startDay) && Objects.equals(endDate, booking.endDate) && Objects.equals(codeCustomer, booking.codeCustomer) && Objects.equals(codeService, booking.codeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBooking, dateBooking, startDay, endDate, codeCustomer, codeService);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", dateBooking='" + dateBooking + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDate='" + endDate + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", codeService='" + codeService + '\'' +
                '}';
    }
}
