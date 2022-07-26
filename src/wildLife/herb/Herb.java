package wildLife.herb;

import island.Location;
import lombok.Getter;
import lombok.Setter;


public class Herb implements Runnable{

    @Getter
    private static int maxCountOnLocation = 200;

    private Location location;

    public Herb(Location location) {
        this.location = location;
    }

    @Getter
    @Setter
    private double remainsHerb = 1;

    public void addHerb(Location location) {
        if (location.getCountHerbsOnLocation() > (getMaxCountOnLocation() - 10)) {
            location.setCountHerbsOnLocation(getMaxCountOnLocation());
        } else {
            location.setCountHerbsOnLocation(location.getCountHerbsOnLocation() + 10);
        }
    }

    @Override
    public void run() {
        addHerb(location);
    }
}
