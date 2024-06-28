package Q1;

public class Car extends Vehicle {
    int numDoors;

    Car(String brand, String model, int numDoors) {
        super(brand, model);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Number of Doors: " + numDoors);
    }
}

