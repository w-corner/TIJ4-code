package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// OK , this not a bug , see LiftOffBug2
public class LiftOffBug implements Runnable{
    private static int taskCount = 0;
    private final int id = taskCount++;

    private void status() {
        System.out.println(Thread.currentThread().getName() + ": " + id);
    }

    @Override
    public void run() {
        status();
    }

    private static void schedule() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new LiftOffBug(), 0, 200, TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();
    }

    private static void common() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {

            executorService.execute(new LiftOffBug());
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        schedule();
        common();
    }
}
