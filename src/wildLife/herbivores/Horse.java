package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Horse extends Herbivore {

    @Getter
    private static int maxCountOnLocation = 20;

    public Horse() {
        super(400, 4, 60);
    }

    @Override
    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }
}
