import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(4);
        executorService.submit(new Service("A", countDownLatch));
        executorService.submit(new Service("B", countDownLatch));
        executorService.submit(new Service("C", countDownLatch));
        executorService.submit(new Service("D", countDownLatch));

        countDownLatch.await();

        System.out.println("Main Thread: " + Thread.currentThread().getName());
        executorService.shutdown();
    }
}