package wildLife.herbivores;

import island.Location;
import lombok.Getter;
import support.RandomNumber;
import wildLife.Herbivore;

import java.util.HashMap;
import java.util.Map;

public class Mouse extends Herbivore {

    @Getter
    private Map<String, Integer> chanceCatch = new HashMap<>();

    {
        chanceCatch.put(Worm.class.getSimpleName(), 90);
    }

    public Mouse() {
        super(0.05, 1, 0.01);
    }

    @Getter
    private static int maxCountOnLocation = 500;

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
