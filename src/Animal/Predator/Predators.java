package Animal.Predator;

import Animal.Animals;

public abstract class Predators extends Animals {
    public Predators(int weight, int speed, int kilogramToSaturate) {
        super(weight, speed, kilogramToSaturate);
    }


    @Override
    public void eat() {

    }
}
