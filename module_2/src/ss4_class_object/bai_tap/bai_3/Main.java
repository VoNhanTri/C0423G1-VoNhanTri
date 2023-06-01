package ss4_class_object.bai_tap.bai_3;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan( Fan.SLOW,false,10,"blue");
        Fan fan2 = new Fan(Fan.MEDIUM,true,5, "yelow");
        Fan fan3 = new Fan(Fan.FAST,false,4, "red");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
        System.out.println(fan3.toString());
    }
}
