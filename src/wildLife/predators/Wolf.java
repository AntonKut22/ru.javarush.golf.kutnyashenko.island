package wildLife.predators;

import lombok.Getter;
import wildLife.Predator;
import wildLife.herbivores.*;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator {

    @Getter
    private Map<String, Integer> chanceCatch;

    {
        chanceCatch = new HashMap<>();
        chanceCatch.put(Horse.class.getSimpleName(), 10);
        chanceCatch.put(Deer.class.getSimpleName(), 15);
        chanceCatch.put(Rabbit.class.getSimpleName(), 60);
        chanceCatch.put(Mouse.class.getSimpleName(), 80);
        chanceCatch.put(Goat.class.getSimpleName(), 60);
        chanceCatch.put(Sheep.class.getSimpleName(), 70);
        chanceCatch.put(Pig.class.getSimpleName(), 15);
        chanceCatch.put(Buffalo.class.getSimpleName(), 10);
        chanceCatch.put(Duck.class.getSimpleName(), 40);
    }

    public Wolf() {
        super(50, 3, 8);
    }

    @Getter
    private static int maxCountOnLocation = 30;

    @Override
    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }

}
