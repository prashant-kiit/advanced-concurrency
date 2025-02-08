package Phaser.RegisterDeregister;

import java.util.concurrent.Phaser;

class CustomPhaser extends Phaser {
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("=== Phase " + (phase + 1) + " completed ===");
        return false; // Return true to terminate, false to continue cycling
    }
}
