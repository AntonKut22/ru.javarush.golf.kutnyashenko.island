import Threads.GameWorker;
import island.IslandCreator;
import island.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        Location[][] islandModel = IslandCreator.createIsland(x, y);

        GameWorker gameWorker = new GameWorker(islandModel);
        gameWorker.start();
    }
}
