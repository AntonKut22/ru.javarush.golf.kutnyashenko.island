package Threads;

import island.Location;
import support.InitAll;

import java.util.Map;

import static java.lang.String.format;

public class PrintStatistic implements Runnable {

    private final Location[][] island;
    private Map<String, Integer> previousStatisticAllIsland;

    public PrintStatistic(Location[][] island) {
        this.island = island;
    }

    @Override
    public void run() {
        printAll();
    }

    public void printAll() {
        Map<String, Integer> statisticAllIsland = InitAll.initAllAtIsland();
        for (Location[] locations : island) {
            for (Location location : locations) {
                Map<String, Integer> statisticAnimalsOnLocation = location.statisticAllAnimalOnLocation();
                Map<String, Integer> statisticHerbOnLocation = location.statisticHerbOnLocation();
                statisticHerbOnLocation.forEach((k, v) -> statisticAllIsland.merge(k, v, Integer::sum));
                statisticAnimalsOnLocation.forEach((k, v) -> statisticAllIsland.merge(k, v, Integer::sum));
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : statisticAllIsland.entrySet()) {
            System.out.printf("%10s%10d%s%n",
                    stringIntegerEntry.getKey(),
                    stringIntegerEntry.getValue(),
                    compareResult(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        }
        previousStatisticAllIsland = statisticAllIsland;
        System.out.println("-------------------------------------------------------------------------------");
    }

    private String compareResult(String key, Integer value) {
        if (previousStatisticAllIsland != null && previousStatisticAllIsland.containsKey(key)) {
            int result = value - previousStatisticAllIsland.get(key);
            return result == 0 ? "" :format("%+10d", result);
        }
        return "";
    }
}

