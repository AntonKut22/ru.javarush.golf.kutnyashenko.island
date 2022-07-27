package wildLife.herb;

import island.Location;
import lombok.Getter;
import lombok.Setter;


public class Herb{

    @Getter
    private static int maxCountOnLocation = 200;

    private Location location;

    public Herb(Location location) {
        this.location = location;
    }

    @Getter
    @Setter
    private double remainsHerb = 1;

}
