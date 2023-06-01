package ss6_inheriance.bai_tap.bai_3;

import java.util.Arrays;

public class RunPoint {
    public static void main(String[] args) {
        Point point = new Point(2,3);
        System.out.println(Arrays.toString(point.getXY()));
        MovablePoint movablePoint = new MovablePoint(2,3,5,6);
        System.out.println(movablePoint.toString());
        System.out.println(movablePoint.move());
    }
}
