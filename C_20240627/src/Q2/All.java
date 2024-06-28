package Q2;

public class All {
    private int batteryCapacity; // 배터리 용량
    private String color; // 색상

    public All(int batteryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "All{" +
                "batteryCapacity=" + batteryCapacity +
                ", color='" + color + "'}";
    }
}

