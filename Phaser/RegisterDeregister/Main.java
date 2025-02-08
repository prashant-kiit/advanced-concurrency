package Phaser.RegisterDeregister;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

class Main {
    public static void main(String[] args) {
        Phaser phaser = new CustomPhaser();
        phaser.bulkRegister(0); // Register all threads at once

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(new Service("A", phaser));
        executorService.submit(new Service("B", phaser));
        executorService.submit(new Service("C", phaser));    
        executorService.submit(new Service("D", phaser));

        executorService.shutdown();
    }
}
