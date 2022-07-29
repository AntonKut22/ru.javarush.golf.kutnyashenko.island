package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Buffalo extends Herbivore {

    @Getter
    private static int maxCountOnLocation = 10;

    public Buffalo() {
        super(700, 3, 100);
    }

    @Override
    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }

}
