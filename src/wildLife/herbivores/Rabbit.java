package wildLife.herbivores;

import lombok.Getter;

public class Rabbit extends Herbivore{

    public Rabbit() {
        super(2, 2, 0.45);
    }

    @Getter
    private static int maxCountOnLocation = 150;
}
