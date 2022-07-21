package wildLife.predators;

import island.Location;
import wildLife.Animals;

public abstract class Predator extends Animals {

    public Predator(double weigh, int speed, double needForFood) {
        super(weigh, speed, needForFood);
    }

    @Override
    public void eat(Location location, Animals animal) {

    }
}
