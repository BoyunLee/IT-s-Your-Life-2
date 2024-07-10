import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {
        CounterThread t1 = new CounterThread();
        TimeThread t2 = new TimeThread();
        EventThread t3 = new EventThread();

        t1.start();
        t2.start();
        t3.start();
    }
}

class CounterThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Counter: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // Do nothing (ignore the exception)
            }
        }
        System.out.println("Counting finished.");
    }
}

class TimeThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Current Time: " + java.time.LocalTime.now());
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // Do nothing (ignore the exception)
            }
        }
    }
}

class EventThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("Event " + i + ">> Award Trophy");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // Do nothing (ignore the exception)
            }
        }
        System.out.println("Event thread finished.");
    }
}
