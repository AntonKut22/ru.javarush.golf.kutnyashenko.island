package wildLife.herbivores;

import lombok.Getter;

public class Worm extends Herbivore{

    public Worm() {
        super(0.01, 0, 0);
    }

    @Getter
    private static int maxCountOnLocation = 1000;
}
