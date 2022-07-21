package wildLife.predators;

import lombok.Getter;

public class Eagle extends Predator{

    public Eagle() {
        super(6, 3, 1);
    }

    @Getter
    private static int maxCountOnLocation = 20;
}
