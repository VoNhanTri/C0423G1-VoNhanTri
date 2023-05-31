package furama_resort.model.person;

import java.util.Objects;

public abstract class Person {
    //Mã khách hàng, Họ tên, Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email
    private String code;
    private String name;
    private String date;
    private String gender;
    private int identityCard;
    private int numberPhone;
    private String email;

    public Person(String code, String name, String date, String gender, int identityCard, int numberPhone, String email) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.identityCard = identityCard;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Person() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(int identityCard) {
        this.identityCard = identityCard;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return identityCard == person.identityCard && numberPhone == person.numberPhone && Objects.equals(code, person.code) && Objects.equals(name, person.name) && Objects.equals(date, person.date) && Objects.equals(gender, person.gender) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, date, gender, identityCard, numberPhone, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCard=" + identityCard +
                ", numberPhone=" + numberPhone +
                ", email='" + email + '\'' +
                '}';
    }
}
