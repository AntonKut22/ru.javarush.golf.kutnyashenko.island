package island;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class IslandLife implements Runnable {

    @Override
    public void run() {
        Location[][] island = CreateIsland.createIsland(10, 10);

        List<Location> locationList = new ArrayList<>();

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                locationList.add(island[i][j]);
            }
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    }
}
