package Q2;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone(80, "red", 20);
        Tablet tablet = new Tablet(70, "blue", false);
        Laptop laptop = new Laptop(100, "silver");
        System.out.println(smartphone);
        System.out.println(tablet);
        System.out.println(laptop);
    }
}
