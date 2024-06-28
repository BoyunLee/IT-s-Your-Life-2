package Q1;

public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, String model, boolean hasCarrier) {
        super(brand, model);
        this.hasCarrier = hasCarrier;
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Has Carrier: " + hasCarrier);
    }
}
