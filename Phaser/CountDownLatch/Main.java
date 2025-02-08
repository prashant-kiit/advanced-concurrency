package Phaser.CountDownLatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(new Service("A", phaser));
        executorService.submit(new Service("B", phaser));
        executorService.submit(new Service("C", phaser));    
        executorService.submit(new Service("D", phaser));

        phaser.awaitAdvance(0);

        System.out.println("Phase 0 Main Thread: " + Thread.currentThread().getName());

        phaser.awaitAdvance(1);

        System.out.println("Phase 1 Main Thread: " + Thread.currentThread().getName());

        executorService.shutdown();

    }
}
