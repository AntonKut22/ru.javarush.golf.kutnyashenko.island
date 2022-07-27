package thread;

import island.Location;
import support.RandomNumber;
import wildLife.Animals;


public class ActivityAnimals implements Runnable{

    private Location location;

    public ActivityAnimals(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

        for (Animals animal : location.getAnimals()) {

            animal.setHungry(animal.getHungry() + 10);


            if (animal.getHungry() > 100){
                location.deleteAnimal(animal);
                return;
            } else if (animal.getHungry() > 50) {
                animal.eat(location);
            } else {

                if (RandomNumber.get(2) == 1) {
                    animal.reproduction(location, animal);
                } else {
                    location.moveAnimals(animal);
                }
            }
        }
    }
}
