package Animal;


import lombok.Getter;

@Getter
public abstract class Animals {

    private int setGender = (int) (Math.random() * 2);

    private final Gender gender;

    private int health = 100;

    private int weight;

    private int speed;

    private int KilogramToSaturate;

    private int maxCountOnLocation;

    public Animals(int weight, int speed, int kilogramToSaturate, int maxCountOnLocation) {
        this.weight = weight;
        this.speed = speed;
        this.KilogramToSaturate = kilogramToSaturate;
        this.maxCountOnLocation = maxCountOnLocation;
        if (setGender == 0){
            this.gender = Gender.FEMALE;
        } else{
            this.gender = Gender.MALE;
        }
    }

    public abstract void eat();

    public abstract void reproduction();

    public abstract void move();

}
