package furama_resort.model.person;

import java.util.Objects;

public class Customer extends Person{
    private String customerType;
    private String address;

    public Customer(String code, String name, String date, String gender, int identityCard, int numberPhone, String email, String customerType) {
        super(code, name, date, gender, identityCard, numberPhone, email);
        this.customerType = customerType;
    }

    public Customer(String customerType) {
        this.customerType = customerType;
    }

    public Customer() {
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerType, customer.customerType) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerType, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                "customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
