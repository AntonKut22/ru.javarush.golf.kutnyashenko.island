package island;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import wildLife.Animals;
import wildLife.Herb;

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

    private int maxUp;
    private int maxDown;
    private int maxLeft;
    private int maxRight;

    public Location(int maxUp, int maxDown, int maxLeft, int maxRight) {
        this.maxUp = maxUp;
        this.maxDown = maxDown;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
    }

    public void printAllAnimals() {

        Map<String, Integer> staticticAnimal = staticticAllAnimalOnLocation();
        for (Map.Entry<String, Integer> stringIntegerEntry : staticticAnimal.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
        System.out.println("Всего животных - " + countAnimalsOnLocation);
        System.out.println("Растений - " + countHerbsOnLocation);
    }

    public Map<String, Integer> staticticAllAnimalOnLocation() {
        Map<String, Integer> staticticAnimal = new HashMap<>();
        for (Animals animal : animals) {
            if (!staticticAnimal.containsKey(animal.getClass().getSimpleName())) {
                staticticAnimal.put(animal.getClass().getSimpleName(), 1);
            } else {
                staticticAnimal.put(animal.getClass().getSimpleName(),
                        staticticAnimal.get(animal.getClass().getSimpleName()) + 1);
            }
        }
        return staticticAnimal;
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

    }

    @Override
    public void run() {

    }
}
