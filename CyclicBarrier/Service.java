package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Service implements Runnable {
    private String name;
    private CyclicBarrier cyclicBarrier;
    private Integer count;

    public Service(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
        this.count = 0;
    }

    @Override
    public void run() {
        try {
            while (count < 5) {
                System.out.println("Before: Service: " + name);
                count++;
                Thread.sleep(1000);
            }
            cyclicBarrier.await();

            while (count < 10) {
                System.out.println("After: Service: " + name);
                count++;
                Thread.sleep(1000);
            }

            cyclicBarrier.await();

            while (count < 15) {
                System.out.println("Next: Service: " + name);
                count++;
                Thread.sleep(1000);
            }

            cyclicBarrier.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
