package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Horse extends Herbivore {

    public Horse() {
        super(400, 4, 60);
    }

    @Getter
    private static int maxCountOnLocation = 20;
}
