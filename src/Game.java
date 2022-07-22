import island.CreateIsland;
import island.Location;
import wildLife.Animals;
import wildLife.herbivores.Buffalo;
import wildLife.herbivores.Mouse;
import wildLife.predators.Bear;
import wildLife.predators.Predator;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {

    public static void main(String[] args) {

        CreateIsland newIsland = new CreateIsland(10, 10);

        Location[][] island = newIsland.createIsland();

        Bear bear = new Bear();
        bear.eat(island[0][0]);



//        island[0][0].printAllAnimals();

//        Mouse mouse = new Mouse();
//        String nameMouseClass = mouse.getClass().getSimpleName();
//
//        List<Animals> test = island[0][0].getAnimals().stream().
//                filter(animals -> animals instanceof Predator).collect(Collectors.toList());
//        for (Animals animals : test) {
//            if (animals instanceof Bear) {
//                if (((Bear) animals).getChanceCatch().containsKey(nameMouseClass)) {
//                    System.out.println("Медведь съел мышь");
//                }
//            }
//        }

//        Mouse mouse = new Mouse();
//        System.out.println(island[0][0].countCurrentAnimalOnLocation(mouse));


//        for (Map.Entry<Integer, Animals> integerAnimalsEntry : island[0][0].getAnimals().entrySet()) {
//            if (integerAnimalsEntry instanceof Buffalo){
//                integerAnimalsEntry.getValue().setLife(false);
//            }
//        }

    }

}
