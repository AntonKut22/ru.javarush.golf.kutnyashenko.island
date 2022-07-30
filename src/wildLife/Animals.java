package wildLife;

import island.Location;
import support.Sides;
import support.RandomNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Animals {

    private static int maxCountOnLocation;

    @Setter
    private int hungry;

    private double weigh;

    private int speed;

    private double needForFood;


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
                (animal.getMaxCountAnimalsOnLocation() - location.countCurrentAnimalOnLocation(animal)) > 2) {
            location.addAnimal(animal);
        }
    }

    public double percentHungryToKilogram() {
        return this.getHungry() * this.getNeedForFood() / 100;
    }

    public int kilogramToPercentHungry(double weighEat) {
        return (int) (weighEat * 100 / this.getNeedForFood());
    }

    public int getMaxCountAnimalsOnLocation(){
        return maxCountOnLocation;
    }
}
