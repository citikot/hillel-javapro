package homework14.part1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation implements Runnable {

    private volatile double amount;
    Random randomizer = new Random();
    Semaphore semaphore;

    public PetrolStation(double amount, Semaphore dispensers) {
        this.amount = amount;
        this.semaphore = dispensers;
    }

    public boolean doRefuel(double refuel) throws InterruptedException {
        boolean isRefuled = true;
        int timeSpent = randomizer.nextInt(7000) + 3000;
        semaphore.acquire();
        amount = amount - refuel;
        if (amount <= 0) {
            semaphore.release();
            isRefuled = false;
            System.out.println(String.format("Fuel on petrol station has gone at dispenser %s.", Thread.currentThread().getName()));
        } else {
            semaphore.release();
            System.out.println(String.format("Dispenser %s was working. The rest of fuel after refuel is %f. Requested refuel was %f. Time spent is %d",
                    Thread.currentThread().getName(), amount, refuel, timeSpent / 1000));
            Thread.sleep(timeSpent);
        }
        return isRefuled;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!doRefuel(randomizer.nextDouble(50.0))) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }
}
