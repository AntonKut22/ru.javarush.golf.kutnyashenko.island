import Animal.Animals;
import Animal.Predator.Wolf;

import java.util.HashMap;
import java.util.Map;

public final class CreateIsland {



    public OneLocation[][] island = new OneLocation[10][10];


    private int numbersOfAnimals = 1; //TODO заменить на 15


    public void create() {
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                OneLocation addLocaation = new OneLocation();
                addLocaation.animals = createAnimalsOnLocation();
                addLocaation.herb = createHerbOnLocation();
                island[i][j] = addLocaation;
            }
        }
    }

    private int createHerbOnLocation() {
        return (int) (Math.random() * 200);
    }

    public Map<Animals, Integer> createAnimalsOnLocation() {
        Map<Animals, Integer> animals = new HashMap<>();
        for (int i = 0; i < numbersOfAnimals; i++) {
            int countAnimalsOnLocation = (int) (Math.random() * Wolf.maxCountOnLocation); //TODO заменить на массив животных
            for (int j = 0; j < countAnimalsOnLocation; j++) {
                animals.put(new Wolf(), countAnimalsOnLocation);
            }
        }
        return animals;
    }
}
