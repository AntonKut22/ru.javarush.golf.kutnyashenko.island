package island;


import lombok.Getter;
import wildLife.Animals;
import wildLife.AnimalArray;
import wildLife.Herb;
import wildLife.herbivores.*;
import wildLife.predators.*;

import java.util.ArrayList;
import java.util.List;

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
                List<Animals> animalsMap = new ArrayList<>();
                List<Herb> herbMap = new ArrayList<>();

                island[i][j] = new Location();
                island[i][j].setCountAnimalsOnLocation(createMapAnimals(animalsMap));
                island[i][j].setCountHerbsOnLocation(createMapHerb(herbMap));
                island[i][j].setAnimals(animalsMap);
                island[i][j].setHerb(herbMap);
            }
        }
        return island;
    }

    private int createMapHerb(List<Herb> herbList){
        int countHerbOnLocation = Random.get(200);
        for (int i = 0; i < countHerbOnLocation; i++) {
            herbList.add(new Herb());
        }
        return countHerbOnLocation;
    }

    private int createMapAnimals(List<Animals> animalsList) {
        int countAllAnimals = 0;
        AnimalArray[] listAnimals = AnimalArray.values();
        for (AnimalArray iterAnimal : listAnimals) {
            switch (iterAnimal)
            {
                case BUFFALO -> {
                    int count = Random.get(Buffalo.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Buffalo());
                    }
                }
                case DEER ->  {
                    int count = Random.get(Deer.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Deer());
                    }
                }
                case DUCK -> {
                    int count = Random.get(Duck.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Duck());
                    }
                }
                case GOAT -> {
                    int count = Random.get(Goat.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Goat());
                    }
                }
                case HORSE -> {
                    int count = Random.get(Horse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Horse());
                    }
                }
                case MOUSE -> {
                    int count = Random.get(Mouse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Mouse());
                    }
                }
                case PIG -> {
                    int count = Random.get(Pig.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Pig());
                    }
                }
                case RABBIT -> {
                    int count = Random.get(Rabbit.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Rabbit());
                    }
                }
                case SHEEP -> {
                    int count = Random.get(Sheep.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Sheep());
                    }
                }
                case WORM -> {
                    int count = Random.get(Worm.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Worm());
                    }
                }
                case BEAR -> {
                    int count = Random.get(Bear.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Bear());
                    }
                }
                case BOA -> {
                    int count = Random.get(Boa.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Boa());
                    }
                }
                case EAGLE -> {
                    int count = Random.get(Eagle.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Eagle());
                    }
                }
                case FOX -> {
                    int count = Random.get(Fox.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Fox());
                    }
                }
                case WOLF -> {
                    int count = Random.get(Wolf.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Wolf());
                    }
                }
            }
        }
        return countAllAnimals;
    }
}
