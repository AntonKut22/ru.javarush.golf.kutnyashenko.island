package wildLife.predators;

import lombok.Getter;

public class Boa extends Predator{

    public Boa() {
        super(15, 1, 3);
    }

    @Getter
    private static int maxCountOnLocation = 30;
}
