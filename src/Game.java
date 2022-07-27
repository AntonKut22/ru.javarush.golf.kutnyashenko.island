import island.CreateIsland;
import island.Location;
import support.PrintStatictic;
import thread.ActivityAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

//        IslandLife islandLife = new IslandLife(2, 2);

        Location[][] island = CreateIsland.createIsland(2, 2);

        List<Location> locationList = new ArrayList<>();

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                locationList.add(island[i][j]);
            }
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            for (Location location : locationList) {
                location.addHerb();
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {

            for (Location location : locationList) {
                executorService.submit(new ActivityAnimals(location));
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new PrintStatictic(island), 1, 5, TimeUnit.SECONDS);

    }

}
