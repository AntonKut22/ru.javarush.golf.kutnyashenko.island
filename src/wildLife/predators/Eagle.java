package wildLife.predators;

import lombok.Getter;
import wildLife.Predator;
import wildLife.herbivores.*;

import java.util.HashMap;
import java.util.Map;

public class Eagle extends Predator {

    @Getter
    private Map<String, Integer> chanceCatch;

    {
        chanceCatch = new HashMap<>();
        chanceCatch.put(Fox.class.getSimpleName(), 10);
        chanceCatch.put(Rabbit.class.getSimpleName(), 90);
        chanceCatch.put(Mouse.class.getSimpleName(), 90);
        chanceCatch.put(Duck.class.getSimpleName(), 80);
    }

    public Eagle() {
        super(6, 3, 1);
    }

    @Getter
    private static int maxCountOnLocation = 20;
}
