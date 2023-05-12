package ss5_access_modifier_static.bai_tap.bai_tap2;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("hiển thị giá trị ban đầu: "+student.toString());
        student.setName("Trí");//set lại giá trị name
        student.setClassic("C03323");//set lại giá trị classic
        System.out.println("hiển thi giá trị sau khi set: "+student.toString());
        System.out.println(student.getName());
        System.out.println(student.getClassic());
    }
}
