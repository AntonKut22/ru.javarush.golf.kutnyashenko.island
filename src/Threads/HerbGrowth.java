package Threads;

import island.Location;

public class HerbGrowth implements Runnable {

    Location[][] locations;

    public HerbGrowth(Location[][] locations) {
        this.locations = locations;
    }

    @Override
    public void run() {
        for (Location[] rows : locations) {
            for (Location location : rows) {
                location.addHerb();
            }
        }
    }
}

