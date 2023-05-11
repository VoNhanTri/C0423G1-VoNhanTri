package ss4_class_object.bai_tap.bai_2;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3,false,10,"red");
        Fan fan2 = new Fan(2,true,5,"blue");
        Fan fan3 = new Fan(1,false,4,"yellow");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
        System.out.println(fan3.toString());
    }
}
