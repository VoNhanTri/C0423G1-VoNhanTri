package ss5_access_modifier_static.bai_tap.bai_tap2;

public class Student {
   private String name;
   private String classic;

    public Student() {
        this.name = "John";
        this.classic = "C02";
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setClassic(String classic) {
        this.classic = classic;
    }

    @Override
    public String toString() { //không hiện kêt quả bằng ô địa chỉ
        return "Student{" +
                "name='" + name + '\'' +
                ", classic='" + classic + '\'' +
                '}';
    }
}
