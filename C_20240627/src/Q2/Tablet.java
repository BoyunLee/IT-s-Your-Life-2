package Q2;

class Tablet extends All{
    private boolean isConnected; // 연결 상태

    public Tablet(int batteryCapacity, String color, boolean isConnected) {
        super(batteryCapacity, color);
        this.isConnected = isConnected;
    }

    public boolean getIsConnected() { return isConnected; }

    @Override
    public String toString() {
        return "Tablet{" +
                "isConnected=" + isConnected +
                ", batteryCapacity=" + getBatteryCapacity() +
                "} " + super.toString();
    }
}
