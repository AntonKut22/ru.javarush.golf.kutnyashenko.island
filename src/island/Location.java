package island;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import wildLife.Animals;
import wildLife.Herb;
import wildLife.herbivores.Buffalo;
import wildLife.herbivores.Mouse;

import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
public class Location {

    private int CountAnimalsOnLocation = 0;
    private int CountHerbsOnLocation = 0;
    private Map<Integer, Animals> animals;
    private Map<Integer, Herb> herb;


    public void printAllAnimals(){
        //TODO сделать хорошо

        int countMouse = 0;

        for (Animals value : animals.values()) {
            if (value instanceof Mouse){
                countMouse++;
            }
        }
        System.out.println(countMouse);
    }
}
