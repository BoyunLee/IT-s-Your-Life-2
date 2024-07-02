package Q1;

public class Main {
    public static void main(String[] args) {
        Computer appleComputer = new AppleComputer();
        appleComputer.start();
        appleComputer.shutdown();
        appleComputer.restart();

        Computer bananaComputer = new BananaComputer();
        bananaComputer.start();
        bananaComputer.shutdown();
        bananaComputer.restart();
    }
}
