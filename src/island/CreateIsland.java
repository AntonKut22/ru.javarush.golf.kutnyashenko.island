package island;


import lombok.Getter;
import wildLife.Animals;
import wildLife.AnimalArray;
import wildLife.Herb;
import wildLife.herbivores.*;
import wildLife.predators.*;

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

    public Location[][] createIsland() {
        island = new Location[width][height];

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                Map<Integer, Animals> animalsMap = new HashMap<>();
                Map<Integer, Herb> herbMap = new HashMap<>();

                island[i][j] = new Location();
                island[i][j].setCountAnimalsOnLocation(createMapAnimals(animalsMap));
                island[i][j].setCountHerbsOnLocation(createMapHerb(herbMap));
                island[i][j].setAnimals(animalsMap);
                island[i][j].setHerb(herbMap);
            }
        }
        return island;
    }

    private int createMapHerb(Map<Integer, Herb> herbMap){
        int countHerbOnLocation = Random.get(200);
        for (int i = 0; i < countHerbOnLocation; i++) {
            herbMap.put(countHerbOnLocation++, new Herb());
        }
        return countHerbOnLocation;
    }

    private int createMapAnimals(Map<Integer, Animals> animalsMap) {
        int countAllAnimals = 0;
        AnimalArray[] listAnimals = AnimalArray.values();
        for (AnimalArray iterAnimal : listAnimals) {
            switch (iterAnimal)
            {
                case BUFFALO -> {
                    int count = Random.get(Buffalo.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Buffalo());
                    }
                }
                case DEER ->  {
                    int count = Random.get(Deer.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Deer());
                    }
                }
                case DUCK -> {
                    int count = Random.get(Duck.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Duck());
                    }
                }
                case GOAT -> {
                    int count = Random.get(Goat.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Goat());
                    }
                }
                case HORSE -> {
                    int count = Random.get(Horse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Horse());
                    }
                }
                case MOUSE -> {
                    int count = Random.get(Mouse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Mouse());
                    }
                }
                case PIG -> {
                    int count = Random.get(Pig.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Pig());
                    }
                }
                case RABBIT -> {
                    int count = Random.get(Rabbit.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Rabbit());
                    }
                }
                case SHEEP -> {
                    int count = Random.get(Sheep.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Sheep());
                    }
                }
                case WORM -> {
                    int count = Random.get(Worm.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Worm());
                    }
                }
                case BEAR -> {
                    int count = Random.get(Bear.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Bear());
                    }
                }
                case BOA -> {
                    int count = Random.get(Boa.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Boa());
                    }
                }
                case EAGLE -> {
                    int count = Random.get(Eagle.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Eagle());
                    }
                }
                case FOX -> {
                    int count = Random.get(Fox.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Fox());
                    }
                }
                case WOLF -> {
                    int count = Random.get(Wolf.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsMap.put(countAllAnimals++, new Wolf());
                    }
                }
            }
        }
        return countAllAnimals;
    }
}
