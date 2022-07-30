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
public class Location {

    private int countAnimalsOnLocation = 0;
    private int countHerbsOnLocation = 0;
    private List<Animals> animals;
    private List<Herb> herb;

    private Location[][] island;
    private int maxUp;
    private int maxDown;
    private int maxLeft;
    private int maxRight;

    public Location(int maxUp, int maxDown, int maxLeft, int maxRight, Location[][] island) {
        this.maxUp = maxUp;
        this.maxDown = maxDown;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
        this.island = island;
    }


    // реализовал статистику по каждой локации, но в данной реализации не использую
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

    public Map<String, Integer> statisticHerbOnLocation() {
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
        if (countHerbsOnLocation > (Herb.getMaxCountOnLocation() - 50)) {
            countHerbsOnLocation = Herb.getMaxCountOnLocation();
        } else {
            countHerbsOnLocation += 50;
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
        switch (sides) {
            case UP -> {
                int stepSize = RandomNumber.get(maxUp);
                if (island[maxUp - stepSize][maxLeft].countCurrentAnimalOnLocation(animals) < animals.getMaxCountAnimalsOnLocation()) {
                    island[maxUp - stepSize][maxLeft].addAnimal(animals);
                    deleteAnimal(animals);
                }
            }
            case DOWN -> {
                int stepSize = RandomNumber.get(maxDown);
                if (island[maxUp + stepSize][maxLeft].countCurrentAnimalOnLocation(animals) < animals.getMaxCountAnimalsOnLocation()) {
                    island[maxUp + stepSize][maxLeft].addAnimal(animals);
                    deleteAnimal(animals);
                }
            }
            case LEFT -> {
                int stepSize = RandomNumber.get(maxLeft);
                if (island[maxUp][maxLeft - stepSize].countCurrentAnimalOnLocation(animals) < animals.getMaxCountAnimalsOnLocation()) {
                    island[maxUp][maxLeft - stepSize].addAnimal(animals);
                    deleteAnimal(animals);
                }
            }
            case RIGHT -> {
                int stepSize = RandomNumber.get(maxRight);
                if (island[maxUp][maxLeft + stepSize].countCurrentAnimalOnLocation(animals) < animals.getMaxCountAnimalsOnLocation()) {
                    island[maxUp][maxLeft + stepSize].addAnimal(animals);
                    deleteAnimal(animals);
                }
            }
        }
    }

    public void activityAnimals() {
        this.getAnimals().forEach(animal -> {
            animal.setHungry(animal.getHungry() + 10);

            if (animal.getHungry() > 100) {
                this.deleteAnimal(animal);
            } else if (animal.getHungry() > 50) {
                animal.eat(this);
            } else {

                if (RandomNumber.get(2) == 1) {
                    animal.reproduction(this, animal);
                } else {
                    this.moveAnimals(animal);
                }
            }
        });
    }
}
