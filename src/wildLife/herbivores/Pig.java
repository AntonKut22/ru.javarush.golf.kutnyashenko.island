package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Pig extends Herbivore {

    public Pig() {
        super(400, 2, 50);
    }

    @Getter
    private static int maxCountOnLocation = 50;
}
