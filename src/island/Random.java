package island;

import java.util.concurrent.ThreadLocalRandom;

public class Random {


    public static int get(int maxNumber) {
        return ThreadLocalRandom.current().nextInt(maxNumber);
    }

}
