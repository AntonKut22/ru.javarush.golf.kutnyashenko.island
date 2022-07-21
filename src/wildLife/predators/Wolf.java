package wildLife.predators;

import lombok.Getter;

public class Wolf extends Predator{

    public Wolf() {
        super(50, 3, 8);
    }

    @Getter
    private static int maxCountOnLocation = 30;

}
