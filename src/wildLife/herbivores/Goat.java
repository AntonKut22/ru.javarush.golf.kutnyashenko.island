package wildLife.herbivores;

import lombok.Getter;

public class Goat extends Herbivore{

    public Goat() {
        super(60, 3, 10);
    }

    @Getter
    private static int maxCountOnLocation = 140;
}
