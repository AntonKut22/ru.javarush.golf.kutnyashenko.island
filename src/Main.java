import Animal.Herbivores.Wolf;

public class Main {

    public static void main(String[] args) {

        Wolf wolf = new Wolf();
        System.out.println(wolf.getGender());
        System.out.println(wolf.getHealth());
        System.out.println(wolf.getKilogramToSaturate());
        System.out.println(wolf.getWeight());
        System.out.println(wolf.getMaxCountOnLocation());
        System.out.println(wolf.getSpeed());

    }

}
