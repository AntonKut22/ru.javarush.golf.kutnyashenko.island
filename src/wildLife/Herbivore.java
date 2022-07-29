package wildLife;

import island.Location;
import lombok.Getter;
import support.RandomNumber;
import wildLife.herb.Herb;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Herbivore extends Animals {

    @Getter
    private Map<String, Integer> chanceCatch;

    public Herbivore(double weigh, int speed, double needForFood) {
        super(weigh, speed, needForFood);
    }

    @Override
    public void eat(Location location) {
        while (this.getHungry() != 0 || location.getCountHerbsOnLocation() == 0) {
            int numberHerbOnList = RandomNumber.get(location.getHerb().size());
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

    public void eatAnimal(Location location) {

        List<Animals> animalsForEat = getAnimalsForEat(location);

        while (this.getHungry() != 0 || !animalsForEat.isEmpty()) {
            int numberExtractionInList = RandomNumber.get(animalsForEat.size());
            Animals extraction = animalsForEat.get(numberExtractionInList);
            double percentLucky = this.getChanceCatch().get(extraction.getClass().getSimpleName());
            if (RandomNumber.get(100) > percentLucky) {
                break;
            }
            double needEatForFullSatiety = this.percentHungryToKilogram();
            if (extraction.getWeigh() > needEatForFullSatiety) {
                this.setHungry(0);
                location.deleteAnimal(extraction);
            } else {
                this.setHungry(this.getHungry() - this.kilogramToPercentHungry(extraction.getWeigh()));
            }
        }
    }

    private List<Animals> getAnimalsForEat(Location location) {
        return location.getAnimals().stream()
                .filter(a -> this.getChanceCatch().containsKey(a.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

}
