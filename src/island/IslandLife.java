package island;


import support.PrintStatictic;
import thread.ActivityAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// В данный момент не используется, наверное нужн будет удалить

public class IslandLife implements Runnable {

    public Location[][] island;

    public IslandLife(int x, int y) {
        this.island = CreateIsland.createIsland(x, y);
    }

    @Override
    public void run() {


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
