package ss4_class_object.bai_tap.bai_3;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    public int speed = SLOW;
    public boolean toggle = false;
    public double radius = 5;
    public String color = "blue";

    public Fan(int speed, boolean toggle, double radius, String color) {
        this.speed = speed;
        this.toggle = toggle;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isToggle() {
        return toggle;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (!toggle) {
            return speed + " " + color + " " + radius + "fan is on";
        } else {
            return "fan is off";
        }
    }
}
