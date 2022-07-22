package wildLife.predators;

import lombok.Getter;
import wildLife.herbivores.*;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Predator{

    @Getter
    private Map<String, Integer> chanceCatch;

    {
        chanceCatch = new HashMap<>();
        chanceCatch.put(Rabbit.class.getSimpleName(), 70);
        chanceCatch.put(Mouse.class.getSimpleName(), 90);
        chanceCatch.put(Duck.class.getSimpleName(), 60);
        chanceCatch.put(Worm.class.getSimpleName(), 40);
    }

    public Fox() {
        super(8, 2, 2);
    }

    @Getter
    private static int maxCountOnLocation = 30;
}
