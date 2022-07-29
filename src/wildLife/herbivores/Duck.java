package wildLife.herbivores;

import island.Location;
import lombok.Getter;
import support.RandomNumber;
import wildLife.Herbivore;
import wildLife.predators.Boa;

import java.util.HashMap;
import java.util.Map;

public class Duck extends Herbivore {

    @Getter
    private Map<String, Integer> chanceCatch = new HashMap<>();

    {
        chanceCatch.put(Worm.class.getSimpleName(), 90);
    }

    public Duck() {
        super(1, 4, 0.15);
    }

    @Getter
    private static int maxCountOnLocation = 200;

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
