package Phaser.CountDownLatch;

import java.util.concurrent.Phaser;

public class Service implements Runnable {
    private String name;
    private Phaser phaser;
    private Integer count;

    public Service(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
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
            phaser.arrive();

            while (count < 10) {
                System.out.println("After: Service: " + name);
                count++;
                Thread.sleep(1000);
            }
            phaser.arrive();

            while (count < 15) {
                System.out.println("Next: Service: " + name);
                count++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
