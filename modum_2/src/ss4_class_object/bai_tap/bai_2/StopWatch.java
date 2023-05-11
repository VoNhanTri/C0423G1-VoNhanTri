package ss4_class_object.bai_tap.bai_2;

public class StopWatch {
    private long starTime = System.currentTimeMillis();
    private long endTime;

    public StopWatch() {

    }

    public long getStarTime() {
        return starTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void star() {
        starTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long milliTime = endTime - starTime;
        return milliTime;
    }
}
