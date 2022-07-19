package island;


import lombok.Getter;
import wildLife.Animals;

import java.util.HashMap;
import java.util.Map;

public class CreateIsland {

    private int width;
    private int height;

    @Getter
    private Location[][] island;


    public CreateIsland(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Location[][] createIsland(){
        island = new Location[width][height];

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                island[i][j] = new Location();
            }
        }
        return island;
    }

    private Map<Animals, Integer> createAnimals(){
        Map<Animals, Integer> animalsMap = new HashMap<>();

    }


}
