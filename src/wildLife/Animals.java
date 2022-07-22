package wildLife;

import island.Location;
import island.Sides;
import support.RandomNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Animals {

    private static int maxCountOnLocation;

    @Setter
    private boolean isLife = true;

    @Setter
    private int hungry = 0;

    private double weigh;

    private int speed;

    private double needForFood;

//    public Map<String, Integer> chanceCatch;

    public Animals(double weigh, int speed, double needForFood) {
        this.weigh = weigh;
        this.speed = speed;
        this.needForFood = needForFood;
    }

    public abstract void eat(Location location);

    public Sides directionOfMovement() {

        return switch (RandomNumber.get(4)) {
            case 1 -> Sides.DOWN;
            case 2 -> Sides.LEFT;
            case 3 -> Sides.RIGHT;
            default -> Sides.UP;
        };
    }

    public void reproduction(Location location, Animals animal) {
        if (location.countCurrentAnimalOnLocation(animal) > 1 &&
                (Animals.maxCountOnLocation - location.countCurrentAnimalOnLocation(animal)) > 2) {
            location.addAnimal(animal);
        }
    }

    public double percentHungryToKilogram() {
        return this.getHungry() * this.getNeedForFood() / 100;
    }

    public int kilogramToPercentHungry(double weighEat) {
        return (int) (weighEat * 100 / this.getNeedForFood());
    }

}
