package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(2, 2, 0.45);
    }

    @Getter
    private static int maxCountOnLocation = 150;
}
