package Q2;

class Smartphone extends All{
    private int cameraResolution; // 카메라 해상도

    public Smartphone(int batteryCapacity, String color, int cameraResolution) {
        super(batteryCapacity, color);
        this.cameraResolution = cameraResolution;
    }

    public int getCameraResolution() { return cameraResolution; }

    @Override
    public String toString() {
        return "Smartphone{" +
                "cameraResolution=" + cameraResolution +
                ", batteryCapacity=" + getBatteryCapacity() +
                "} " + super.toString();
    }
}
