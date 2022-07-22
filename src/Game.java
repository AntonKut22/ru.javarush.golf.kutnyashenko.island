import island.CreateIsland;
import island.Location;
import support.PrintStatictic;
import wildLife.predators.Bear;

public class Game {

    public static void main(String[] args) {

        Location[][] newIsland = CreateIsland.createIsland(5, 5);

//        Location[][] island = newIsland.createIsland();

        PrintStatictic printStatictic = new PrintStatictic(newIsland);
        printStatictic.printAll();



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
