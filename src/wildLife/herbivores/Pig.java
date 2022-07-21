package wildLife.herbivores;

import lombok.Getter;

public class Pig extends Herbivore{

    public Pig() {
        super(400, 2, 50);
    }

    @Getter
    private static int maxCountOnLocation = 50;
}
