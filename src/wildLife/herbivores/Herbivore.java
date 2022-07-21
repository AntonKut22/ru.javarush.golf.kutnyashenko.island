package wildLife.herbivores;

import island.Location;
import wildLife.Animals;
import wildLife.Herb;

public abstract class Herbivore extends Animals {

    public Herbivore(double weigh, int speed, double needForFood) {
        super(weigh, speed, needForFood);
    }

    @Override
    public void eat(Location location, Animals animal) {
        while (animal.getSatiety() == 100 || location.getCountHerbsOnLocation() == 0){
            Integer herbKey = location.getHerb() instanceof Herb;
            double weighHerb = location.getHerb().get()
        }

    }
}
