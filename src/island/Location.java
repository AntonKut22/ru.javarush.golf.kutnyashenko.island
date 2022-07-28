package island;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import support.RandomNumber;
import support.Sides;
import wildLife.Animals;
import wildLife.herb.Herb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class Location implements Runnable{

    private int countAnimalsOnLocation = 0;
    private int countHerbsOnLocation = 0;
    private List<Animals> animals;
    private List<Herb> herb;

    private Location[][] island;
    private int maxUp;
    private int maxDown;
    private int maxLeft;
    private int maxRight;

    public Location(Location[][] island, int maxUp, int maxDown, int maxLeft, int maxRight) {
        this.island = island;
        this.maxUp = maxUp;
        this.maxDown = maxDown;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
    }

    public void printAllAnimals() {

        Map<String, Integer> staticticAnimal = statisticAllAnimalOnLocation();
        for (Map.Entry<String, Integer> stringIntegerEntry : staticticAnimal.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
        System.out.println("Всего животных - " + countAnimalsOnLocation);
        System.out.println("Растений - " + countHerbsOnLocation);
    }

    public Map<String, Integer> statisticAllAnimalOnLocation() {
        Map<String, Integer> statisticAnimal = new HashMap<>();
        for (Animals animal : animals) {
            if (!statisticAnimal.containsKey(animal.getClass().getSimpleName())) {
                statisticAnimal.put(animal.getClass().getSimpleName(), 1);
            } else {
                statisticAnimal.put(animal.getClass().getSimpleName(),
                        statisticAnimal.get(animal.getClass().getSimpleName()) + 1);
            }
        }
        return statisticAnimal;
    }

    public Map<String, Integer> statisticHerbOnLocation(){
        Map<String, Integer> statisticHerb = new HashMap<>();
        for (Herb herb1 : herb) {
            statisticHerb.put(herb1.getClass().getSimpleName(), countHerbsOnLocation);
        }
        return statisticHerb;
    }

    public void deleteHerb(int i) {
        herb.remove(i);
    }


    public void addHerb() {
        if (countHerbsOnLocation > (Herb.getMaxCountOnLocation() - 10)) {
            countHerbsOnLocation = Herb.getMaxCountOnLocation();
        } else {
            countHerbsOnLocation += 10;
        }
    }

    public void deleteAnimal(Animals animal) {
        animals.remove(animal);
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public int countCurrentAnimalOnLocation(Animals animal) {
        int count = 0;
        for (Animals animal1 : animals) {
            if (animal.getClass().equals(animal1.getClass())) {
                count++;
            }
        }
        return count;
    }

    public void moveAnimals(Animals animals) {
        Sides sides = animals.directionOfMovement();
        switch (sides) { //TODO добавить проверку на максимальное количество животных в локации
            case UP -> {
                int stepSize = RandomNumber.get(maxUp);
                island[maxUp - stepSize][maxLeft].addAnimal(animals);
                deleteAnimal(animals);
            }
            case DOWN -> {
                int stepSize = RandomNumber.get(maxDown);
                island[maxUp + stepSize][maxLeft].addAnimal(animals);
                deleteAnimal(animals);
            }
            case LEFT -> {
                int stepSize = RandomNumber.get(maxLeft);
                island[maxUp][maxLeft - stepSize].addAnimal(animals);
                deleteAnimal(animals);
            }
            case RIGHT -> {
                int stepSize = RandomNumber.get(maxRight);
                island[maxUp][maxLeft + stepSize].addAnimal(animals);
                deleteAnimal(animals);
            }
        }
    }

    @Override
    public void run() {

    }
}
