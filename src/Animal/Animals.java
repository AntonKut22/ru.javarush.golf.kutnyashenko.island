package Animal;

import Animal.Gender;
import lombok.Getter;


@Getter
public abstract class Animals {


    private int setGender = (int) (Math.random() * 2);

    private final Gender gender;

    private int satiety = 100;

    private int weight;

    private int speed;

    private int KilogramToSaturate;


    public Animals(int weight, int speed, int kilogramToSaturate) {
        this.weight = weight;
        this.speed = speed;
        this.KilogramToSaturate = kilogramToSaturate;
        if (setGender == 0){
            this.gender = Gender.FEMALE;
        } else{
            this.gender = Gender.MALE;
        }
    }

    public void eat(OneLocation oneLocation) {

    }

    public abstract void reproduction();

    public void move(){

    }

}
