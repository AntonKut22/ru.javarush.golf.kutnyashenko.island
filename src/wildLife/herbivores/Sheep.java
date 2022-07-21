package wildLife.herbivores;

import lombok.Getter;

public class Sheep extends Herbivore{

    public Sheep() {
        super(70, 3, 15);
    }

    @Getter
    private static int maxCountOnLocation = 140;
}
