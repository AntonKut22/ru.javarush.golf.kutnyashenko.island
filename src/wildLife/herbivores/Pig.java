package wildLife.herbivores;

import island.Location;
import lombok.Getter;
import support.RandomNumber;
import wildLife.Herbivore;

import java.util.HashMap;
import java.util.Map;

public class Pig extends Herbivore {

    @Getter
    private Map<String, Integer> chanceCatch = new HashMap<>();

    {
        chanceCatch.put(Worm.class.getSimpleName(), 90);
        chanceCatch.put(Mouse.class.getSimpleName(), 50);
    }

    public Pig() {
        super(400, 2, 50);
    }

    @Getter
    private static int maxCountOnLocation = 50;

    @Override
    public void eat(Location location) {
        if (RandomNumber.get(2) == 0) {
            super.eat(location);
        } else {
            eatAnimal(location);
        }
    }

    @Override
    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }
}
