package island;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import wildLife.Animals;
import wildLife.Herb;
import wildLife.herbivores.Mouse;

import java.util.List;

@ToString
@Getter
@Setter
public class Location {

    private int countAnimalsOnLocation = 0;
    private int countHerbsOnLocation = 0;
    private List<Animals> animals;
    private List<Herb> herb;


    public void printAllAnimals() {
        //TODO сделать хорошо

        int countMouse = 0;

        for (Animals value : animals) {
            if (value instanceof Mouse) {
                countMouse++;
            }
        }
        System.out.println(countMouse);
    }

    public void deleteHerb(int i) {
        herb.remove(i);
    }

    public void deleteAnimal(int i) {
        animals.remove(i);
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
}
