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

    public void reproduction(Location location) {
        if (location.countCurrentAnimalOnLocation(this) > 1 &&
                (getMaxCountAnimalsOnLocation() - location.countCurrentAnimalOnLocation(this)) > 2) {
            location.addAnimal(this);
        }
    }

    public double percentHungryToKilogram() {
        return this.getHungry() * this.getNeedForFood() / 100;
    }

    public int kilogramToPercentHungry(double weighEat) {
        return (int) (weighEat * 100 / this.getNeedForFood());
    }

    public int getMaxCountAnimalsOnLocation() {
        return maxCountOnLocation;
    }

    public void activity(Location location) {
        setHungry(getHungry() + 10);

        if (getHungry() > 100) {
            location.deleteAnimal(this);
        } else if (getHungry() > 50) {
            eat(location);
        } else {
            if (RandomNumber.get(2) == 1) {
                reproduction(location);
            } else {
                move(location);
            }
        }
    }

    public void move(Location location) {
        Sides sides = directionOfMovement();
        switch (sides) {
            case UP ->   up(location);
            case DOWN -> down(location);
            case LEFT -> left(location);
            case RIGHT -> right(location);
        }
    }

    private void right(Location location) {
        int stepSize = RandomNumber.get(location.getMaxRight());
        if (location.getIsland()[location.getMaxUp()][location.getMaxLeft() + stepSize]
                .countCurrentAnimalOnLocation(this) < getMaxCountAnimalsOnLocation()) {
            location.getIsland()[location.getMaxUp()][location.getMaxLeft() + stepSize].addAnimal(this);
            location.deleteAnimal(this);
        }
    }

    private void left(Location location) {
        int stepSize = RandomNumber.get(location.getMaxLeft());
        if (location.getIsland()[location.getMaxUp()][location.getMaxLeft() - stepSize]
                .countCurrentAnimalOnLocation(this) < getMaxCountAnimalsOnLocation()) {
            location.getIsland()[location.getMaxUp()][location.getMaxLeft() - stepSize].addAnimal(this);
            location.deleteAnimal(this);
        }
    }

    private void down(Location location) {
        int stepSize = RandomNumber.get(location.getMaxDown());
        if (location.getIsland()[location.getMaxUp() + stepSize][location.getMaxLeft()]
                .countCurrentAnimalOnLocation(this) < getMaxCountAnimalsOnLocation()) {
            location.getIsland()[location.getMaxUp() + stepSize][location.getMaxLeft()].addAnimal(this);
            location.deleteAnimal(this);
        }
    }

    private void up(Location location) {
        int stepSize = RandomNumber.get(location.getMaxUp());
        if (location.getIsland()[location.getMaxUp() - stepSize][location.getMaxLeft()]
                .countCurrentAnimalOnLocation(this) < getMaxCountAnimalsOnLocation()) {
            location.getIsland()[location.getMaxUp() - stepSize][location.getMaxLeft()].addAnimal(this);
            location.deleteAnimal(this);
        }
    }
}
