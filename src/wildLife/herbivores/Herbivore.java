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
    public void eat(Location location) {
        while (this.getHungry() != 0 || location.getCountHerbsOnLocation() == 0) {
            int numberHerbOnList = Random.get(location.getHerb().size());
            Herb herbRemains = location.getHerb().get(numberHerbOnList);
            double weighHerb = herbRemains.getRemainsHerb();
            double needEatForFullSatiety = this.percentHungryToKilogram();
            if (weighHerb > needEatForFullSatiety) {
                herbRemains.setRemainsHerb(weighHerb - needEatForFullSatiety);
                this.setHungry(0);
            } else {
                this.setHungry(this.getHungry() - this.kilogramToPercentHungry(weighHerb));
                location.deleteHerb(numberHerbOnList);
            }
        }
    }
}
