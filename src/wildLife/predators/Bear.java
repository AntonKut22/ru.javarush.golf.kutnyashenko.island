package wildLife.predators;

import lombok.Getter;
import wildLife.herbivores.*;

import java.util.HashMap;
import java.util.Map;

public class Bear extends Predator {

    @Getter
    private Map<String, Integer> chanceCatch = new HashMap<>();

    {
        chanceCatch.put(Boa.class.getSimpleName(), 80);
        chanceCatch.put(Horse.class.getSimpleName(), 40);
        chanceCatch.put(Deer.class.getSimpleName(), 80);
        chanceCatch.put(Rabbit.class.getSimpleName(), 80);
        chanceCatch.put(Mouse.class.getSimpleName(), 90);
        chanceCatch.put(Goat.class.getSimpleName(), 70);
        chanceCatch.put(Sheep.class.getSimpleName(), 70);
        chanceCatch.put(Pig.class.getSimpleName(), 50);
        chanceCatch.put(Buffalo.class.getSimpleName(), 20);
        chanceCatch.put(Duck.class.getSimpleName(), 10);
    }


    public Bear() {
        super(500, 2, 80);
    }

    @Getter
    private static int maxCountOnLocation = 5;


}
