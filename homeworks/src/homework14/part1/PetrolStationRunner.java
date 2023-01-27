package homework14.part1;

import java.util.concurrent.Semaphore;

public class PetrolStationRunner {
    public static void main(String[] args) {
        double stationCapasity = 386.7;
        Semaphore dispensers = new Semaphore(3);
        PetrolStation ps = new PetrolStation(stationCapasity, dispensers);

        Thread dispenser1 = new Thread(ps);
        Thread dispenser2 = new Thread(ps);
        Thread dispenser3 = new Thread(ps);

        dispenser1.start();
        dispenser2.start();
        dispenser3.start();

    }
}
