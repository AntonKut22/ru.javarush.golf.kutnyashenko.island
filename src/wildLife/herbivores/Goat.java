package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Goat extends Herbivore {

    public Goat() {
        super(60, 3, 10);
    }

    @Getter
    private static int maxCountOnLocation = 140;

    @Override
    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }
}
