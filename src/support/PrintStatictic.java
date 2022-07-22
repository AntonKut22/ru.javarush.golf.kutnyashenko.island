package support;

import island.Location;

import java.util.HashMap;
import java.util.Map;

public class PrintStatictic implements Runnable{

    Location[][] island;

    public PrintStatictic(Location[][] island) {
        this.island = island;
    }

    @Override
    public void run() {
        printAll();
    }

    public void printAll() {
        Map<String, Integer> statisticAllIsland = InitAll.initAllAtIsland();
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                Map<String, Integer> statisticAnimalsOnLocation = island[i][j].staticticAllAnimalOnLocation();
                Map<String, Integer> statisticHerbOnLocation = island[i][j].statisticHerbOnLocation();
                statisticHerbOnLocation.forEach((k, v) -> statisticAllIsland.merge(k, v, Integer::sum));
                statisticAnimalsOnLocation.forEach((k, v) -> statisticAllIsland.merge(k, v, Integer::sum));
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : statisticAllIsland.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
    }
}

