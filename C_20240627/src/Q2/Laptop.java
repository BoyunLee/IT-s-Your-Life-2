package Q2;

class Laptop extends All{
    public Laptop(int batteryCapacity, String color) {
        super(batteryCapacity, color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + getBatteryCapacity() +
                "} " + super.toString();
    }
}
