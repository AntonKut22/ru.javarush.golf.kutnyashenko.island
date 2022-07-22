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
        Map<String, Integer> statisticAllIsland = new HashMap<>(); //TODO добавить инициализацию всеми животными
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                Map<String, Integer> statisticOnLocation = island[i][j].staticticAllAnimalOnLocation();
                statisticAllIsland.forEach((k, v) -> statisticOnLocation.merge(k, v, (k1, k2) -> k1 + k2));
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : statisticAllIsland.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
    }
}

