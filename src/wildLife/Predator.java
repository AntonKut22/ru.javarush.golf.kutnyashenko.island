package wildLife;

import island.Location;
import support.RandomNumber;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Predator extends Animals {

    @Getter
    private Map<String, Integer> chanceCatch;

    public Predator(double weigh, int speed, double needForFood) {
        super(weigh, speed, needForFood);
    }

    @Override
    public void eat(Location location) {

        List<Animals> animalsForEat = getAnimalsForEat(location);

        while (this.getHungry() != 0 || !animalsForEat.isEmpty()) {
            int numberExtractionInList = RandomNumber.get(animalsForEat.size());
            Animals extraction = animalsForEat.get(numberExtractionInList);
            double percentLucky = this.getChanceCatch().get(extraction.getClass().getSimpleName());
            if (RandomNumber.get(100) > percentLucky) {
                break;
            }
            double needEatForFullSatiety = this.percentHungryToKilogram();
            eatingAnimal(location, extraction, needEatForFullSatiety);
        }
    }

    private void eatingAnimal(Location location, Animals extraction, double needEatForFullSatiety) {
        if (extraction.getWeigh() > needEatForFullSatiety) {
            this.setHungry(0);
            location.deleteAnimal(extraction);
        } else {
            this.setHungry(this.getHungry() - this.kilogramToPercentHungry(extraction.getWeigh()));
        }
    }

    private List<Animals> getAnimalsForEat(Location location) {
        return location.getAnimals().stream()
                .filter(a -> this.getChanceCatch().containsKey(a.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }
}
