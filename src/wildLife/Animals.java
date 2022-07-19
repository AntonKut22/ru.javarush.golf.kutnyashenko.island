package wildLife;

import island.Location;
import island.Random;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public abstract class Animals {

    private boolean isLife = true;

    private int satiety = 100;



    public abstract void eat(Location location);

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
