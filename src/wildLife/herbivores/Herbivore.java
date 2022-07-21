package wildLife.herbivores;

import island.Location;
import island.Random;
import wildLife.Animals;
import wildLife.Herb;

public abstract class Herbivore extends Animals {

    public Herbivore(double weigh, int speed, double needForFood) {
        super(weigh, speed, needForFood);
    }

    @Override //todo добавить сколько может съесть за один ход
    public void eat(Location location, Animals animal) {
        while (animal.getHungry() == 0 || location.getCountHerbsOnLocation() == 0){
            int numberHerbOnList = Random.get(location.getHerb().size());
            Herb herbRemains = location.getHerb().get(numberHerbOnList);
            double weighHerb = herbRemains.getRemainsHerb();
            double needEatForFullSatiety = animal.percentToKilogram(animal);
            if (weighHerb > needEatForFullSatiety){
                herbRemains.setRemainsHerb(weighHerb - needEatForFullSatiety);
                animal.setHungry(100);
            } else {
                animal.setHungry(animal.kilogramToPercent(animal, weighHerb) + animal.getHungry());
                location.deleteHerb(numberHerbOnList);
            }
        }
    }


}
