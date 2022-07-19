package Animal.Predator;

import lombok.Getter;

@Getter
public class Wolf extends Predators {

    public static final int maxCountOnLocation = 30;

    public Wolf() {
        super(50, 3, 8);
    }

    @Override
    public void eat() {

    }

    @Override
    public void reproduction() {

    }

    @Override
    public void move() {

    }


}
