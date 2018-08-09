package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// sell ticket
public class LiftOffBug2 implements Runnable {

    private static volatile int ticletCount = 100;
    private int value;

    @Override
    public void run() {
        while (ticletCount > 0) {

            value = ticletCount--;
            System.out.println(Thread.currentThread().getName() + ": " + ticletCount);
        }
    }

    public static void main(String[] args) {
        LiftOffBug2 ticket = new LiftOffBug2();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(ticket);
        }
        executorService.shutdown();
    }
}
