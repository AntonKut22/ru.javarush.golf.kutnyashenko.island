package Threads;

import island.Location;
import wildLife.Animals;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AnimalActivity implements Runnable {

    Location[][] locations;
    String name;
    private final Queue<Animals> activityAnimals = new ConcurrentLinkedQueue<>();

    public AnimalActivity(Location[][] locations, String name) {
        this.locations = locations;
        this.name = name;
    }

    @Override
    public void run() {
        for (Location[] rows : locations) {
            for (Location location : rows) {
                createActivityAnimalsForLocation(location);
            }
        }
    }

    private void createActivityAnimalsForLocation(Location location) {
        if (location.statisticAllAnimalOnLocation().get(name) != 0) {
            for (Animals animal : location.getAnimals()) {
                if (animal.getClass().getSimpleName().equals(name)) {
                    activityAnimals.add(animal);
                }
            }
        }
        activityAnimals.forEach(animals -> animals.activity(location));
        activityAnimals.clear();

    }
}

