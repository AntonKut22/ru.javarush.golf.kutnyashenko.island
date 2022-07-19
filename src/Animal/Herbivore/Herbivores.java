package Animal.Herbivore;

import Animal.Animals;

public abstract class Herbivores extends Animals {



    public Herbivores(int weight, int speed, int kilogramToSaturate) {
        super(weight, speed, kilogramToSaturate);
    }

    @Override
    public void eat(OneLocation oneLocation) {

    }
}
