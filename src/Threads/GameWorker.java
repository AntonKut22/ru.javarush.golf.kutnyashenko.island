package Threads;

import island.Location;
import support.InitAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread{

    private final Location[][] locations;
    List<String> nameWildLife = new ArrayList<>(InitAll.initAllAtIsland().keySet());

    public GameWorker(Location[][] locations) {
        this.locations = locations;
    }

    @Override
    public void run() {
        PrintStatistic printStatistic = new PrintStatistic(locations);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(this::running, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(printStatistic, 1, 5, TimeUnit.SECONDS);
    }

    private void running(){

        List<AnimalActivity> animalActivities = new ArrayList<>();
        for (String name : nameWildLife) {
            animalActivities.add(new AnimalActivity(locations, name));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        HerbGrowth herbGrowth = new HerbGrowth(locations);

        executorService.submit(herbGrowth);
        for (AnimalActivity animalActivity : animalActivities) {
            executorService.submit(animalActivity);
        }
    }
}
