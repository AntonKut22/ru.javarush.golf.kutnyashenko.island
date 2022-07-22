package wildLife.predators;

import lombok.Getter;
import wildLife.herbivores.*;

import java.util.HashMap;
import java.util.Map;

public class Boa extends Predator{

    @Getter
    private Map<String, Integer> chanceCatch;

    {
        chanceCatch = new HashMap<>();
        chanceCatch.put(Fox.class.getSimpleName(), 15);
        chanceCatch.put(Rabbit.class.getSimpleName(), 20);
        chanceCatch.put(Mouse.class.getSimpleName(), 40);
        chanceCatch.put(Duck.class.getSimpleName(), 10);
    }

    public Boa() {
        super(15, 1, 3);
    }

    @Getter
    private static int maxCountOnLocation = 30;
}
