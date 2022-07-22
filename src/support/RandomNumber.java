package support;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumber {

    private RandomNumber() {
    }

    public static int get(int maxNumber) {
        return ThreadLocalRandom.current().nextInt(maxNumber);
    }
}
