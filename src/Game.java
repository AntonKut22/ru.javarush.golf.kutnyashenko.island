import island.CreateIsland;
import island.Location;
import support.PrintStatistic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать в моделирование жизни острова.");
        System.out.println("Введите ширину острова (от 1 до 100):");
        int x;
        int y;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(reader.readLine());
            while (x < 1 || x > 100) {
                System.out.println("Вы ввели некорректное число, попробуйте ещё раз");
                System.out.println("Введите ширину острова (от 1 до 100):");
                x = Integer.parseInt(reader.readLine());
            }
            System.out.println("Введите высоту острова (от 1 до 100):");
            y = Integer.parseInt(reader.readLine());
            while (y < 1 || y > 100) {
                System.out.println("Вы ввели некорректное число, попробуйте ещё раз");
                System.out.println("Введите высоту острова (от 1 до 100):");
                y = Integer.parseInt(reader.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Location[][] island = CreateIsland.createIsland(x, y);

        List<Location> locationList = new ArrayList<>();

        for (Location[] locations : island) {
            locationList.addAll(Arrays.asList(locations));
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        scheduledExecutorService.scheduleAtFixedRate(() ->
                locationList.forEach(Location::addHerb), 0, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> locationList.forEach(location ->
                executorService.submit(location::activityAnimals)), 0, 1, TimeUnit.SECONDS);

        PrintStatistic printStatictic = new PrintStatistic(island);
        scheduledExecutorService.scheduleAtFixedRate(printStatictic, 1, 5, TimeUnit.SECONDS);
    }

}
