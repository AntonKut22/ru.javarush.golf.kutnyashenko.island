package wildLife.herbivores;

import lombok.Getter;
import wildLife.Animals;

public class Buffalo extends Herbivore{

    @Getter
    private static int maxCountOnLocation = 10;

    public Buffalo() {
        super(700, 3, 100);
    }



}
