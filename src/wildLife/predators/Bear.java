package wildLife.predators;

import lombok.Getter;

public class Bear extends Predator{

    public Bear() {
        super(500, 2, 80);
    }

    @Getter
    private static int maxCountOnLocation = 5;
}
