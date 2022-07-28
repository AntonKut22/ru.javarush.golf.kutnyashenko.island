package island;


import support.RandomNumber;
import wildLife.Animals;
import wildLife.AnimalArray;
import wildLife.herb.Herb;
import wildLife.herbivores.*;
import wildLife.predators.*;

import java.util.ArrayList;
import java.util.List;

public class CreateIsland {

    public static Location[][] createIsland(int width, int height) {
        Location[][] island = new Location[width][height];

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                List<Animals> animalsList = new ArrayList<>();
                List<Herb> herbList = new ArrayList<>();

                island[i][j] = new Location(i, island.length - i - 1,
                        j, island[i].length - j - 1);
                island[i][j].setCountAnimalsOnLocation(createListAnimals(animalsList));
                island[i][j].setCountHerbsOnLocation(createListHerb(herbList, island[i][j]));
                island[i][j].setAnimals(animalsList);
                island[i][j].setHerb(herbList);
            }
        }
        return island;
    }

    private static int createListHerb(List<Herb> herbList, Location location){
        int countHerbOnLocation = RandomNumber.get(Herb.getMaxCountOnLocation());
        for (int i = 0; i < countHerbOnLocation; i++) {
            herbList.add(new Herb(location));
        }
        return countHerbOnLocation;
    }

    private static int createListAnimals(List<Animals> animalsList) {
        int countAllAnimals = 0;
        AnimalArray[] listAnimals = AnimalArray.values();
        for (AnimalArray iterAnimal : listAnimals) {
            switch (iterAnimal)
            { //TODO Упростить
                case BUFFALO -> {
                    int count = RandomNumber.get(Buffalo.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Buffalo());
                    }
                    countAllAnimals += count;
                }
                case DEER ->  {
                    int count = RandomNumber.get(Deer.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Deer());
                    }
                    countAllAnimals += count;
                }
                case DUCK -> {
                    int count = RandomNumber.get(Duck.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Duck());
                    }
                    countAllAnimals += count;
                }
                case GOAT -> {
                    int count = RandomNumber.get(Goat.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Goat());
                    }
                    countAllAnimals += count;
                }
                case HORSE -> {
                    int count = RandomNumber.get(Horse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Horse());
                    }
                    countAllAnimals += count;
                }
                case MOUSE -> {
                    int count = RandomNumber.get(Mouse.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Mouse());
                    }
                    countAllAnimals += count;
                }
                case PIG -> {
                    int count = RandomNumber.get(Pig.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Pig());
                    }
                    countAllAnimals += count;
                }
                case RABBIT -> {
                    int count = RandomNumber.get(Rabbit.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Rabbit());
                    }
                    countAllAnimals += count;
                }
                case SHEEP -> {
                    int count = RandomNumber.get(Sheep.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Sheep());
                    }
                    countAllAnimals += count;
                }
                case WORM -> {
                    int count = RandomNumber.get(Worm.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Worm());
                    }
                    countAllAnimals += count;
                }
                case BEAR -> {
                    int count = RandomNumber.get(Bear.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Bear());
                    }
                    countAllAnimals += count;
                }
                case BOA -> {
                    int count = RandomNumber.get(Boa.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Boa());
                    }
                    countAllAnimals += count;
                }
                case EAGLE -> {
                    int count = RandomNumber.get(Eagle.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Eagle());
                    }
                    countAllAnimals += count;
                }
                case FOX -> {
                    int count = RandomNumber.get(Fox.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Fox());
                    }
                    countAllAnimals += count;
                }
                case WOLF -> {
                    int count = RandomNumber.get(Wolf.getMaxCountOnLocation());
                    for (int i = 0; i < count; i++) {
                        animalsList.add(new Wolf());
                    }
                    countAllAnimals += count;
                }
            }
        }
        return countAllAnimals;
    }
}
