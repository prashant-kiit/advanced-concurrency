package CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                () -> System.out.println("Main Thread: " + Thread.currentThread().getName()));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(new Service("A", cyclicBarrier));
        executorService.submit(new Service("B", cyclicBarrier));
        executorService.submit(new Service("C", cyclicBarrier));
        executorService.submit(new Service("D", cyclicBarrier));

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        executorService.shutdown();
    }
}
