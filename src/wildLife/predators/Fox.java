package wildLife.predators;

import lombok.Getter;

public class Fox extends Predator{

    public Fox() {
        super(8, 2, 2);
    }

    @Getter
    private static int maxCountOnLocation = 30;
}
