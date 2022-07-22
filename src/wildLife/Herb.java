package wildLife;

import lombok.Getter;
import lombok.Setter;


public class Herb {

    @Getter
    private static int maxCountOnLocation = 200;

    @Getter
    @Setter
    private double remainsHerb = 1;

}
