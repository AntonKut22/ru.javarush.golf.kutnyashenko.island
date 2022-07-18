package Animal.Herbivores;

import Animal.Animals;
import lombok.Getter;

@Getter
public class Wolf extends Animals implements Herbivores{

    public Wolf() {
        super(50, 3, 8, 30);
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
