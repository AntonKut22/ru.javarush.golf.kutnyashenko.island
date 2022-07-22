package wildLife.herbivores;

import lombok.Getter;
import wildLife.Herbivore;

public class Mouse extends Herbivore {

    public Mouse() {
        super(0.05, 1, 0.01);
    }

    @Getter
    private static int maxCountOnLocation = 500;
}
