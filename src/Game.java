import island.CreateIsland;
import island.Location;
import wildLife.Animals;
import wildLife.herbivores.Buffalo;
import wildLife.herbivores.Mouse;

import java.util.Map;

public class Game {

    public static void main(String[] args) {

        CreateIsland newIsland = new CreateIsland(10, 10);

        Location[][] island = newIsland.createIsland();

//        island[0][0].printAllAnimals();

        Mouse mouse = new Mouse();
        System.out.println(island[0][0].countCurrentAnimalOnLocation(mouse));


//        for (Map.Entry<Integer, Animals> integerAnimalsEntry : island[0][0].getAnimals().entrySet()) {
//            if (integerAnimalsEntry instanceof Buffalo){
//                integerAnimalsEntry.getValue().setLife(false);
//            }
//        }

    }

}
