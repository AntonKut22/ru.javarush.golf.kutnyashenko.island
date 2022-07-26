package island;


import lombok.Getter;
import support.PrintStatictic;
import thread.GrowHerb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class IslandLife implements Runnable {

    public Location[][] island = CreateIsland.createIsland(10, 10);

    @Override
    public void run() {


        List<Location> locationList = new ArrayList<>();

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                locationList.add(island[i][j]);
            }
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        executorService.scheduleAtFixedRate(new GrowHerb(locationList), 0, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new PrintStatictic(island), 0, 5, TimeUnit.SECONDS);


    }
}
