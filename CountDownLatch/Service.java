import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {
    private String name;
    private CountDownLatch countDownLatch;
    private Integer count;

    public Service(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
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
            countDownLatch.countDown();

            while (count < 10) {
                System.out.println("After: Service: " + name);
                count++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
