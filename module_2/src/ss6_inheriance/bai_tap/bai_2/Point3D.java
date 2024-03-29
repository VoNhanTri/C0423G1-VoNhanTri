package ss6_inheriance.bai_tap.bai_2;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = {this.getX(), this.getY(), this.z};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" +getX()+
                "y="+getY()+
                "z=" + z +
                '}';
    }
}
