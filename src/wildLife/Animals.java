package wildLife;

import island.Location;
import island.Random;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public abstract class Animals {

    @Setter
    private boolean isLife = true;

    @Setter
    private int satiety = 100;

    private double weigh;

    private int speed;

    private double needForFood;

    public Animals(double weigh, int speed, double needForFood) {
        this.weigh = weigh;
        this.speed = speed;
        this.needForFood = needForFood;
    }

    public abstract void eat(Location location, Animals animal);

    public SidesWorld directionOfMovement(){

        return switch (Random.get(5)){
            case 1 -> SidesWorld.SOUTH;
            case 2 -> SidesWorld.EAST;
            case 3 -> SidesWorld.WEST;
            default -> SidesWorld.NORTH;
        };
    }

    public void reproduction(Location location){


    }

}
