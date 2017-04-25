package utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nicola on 21/04/17.
 */
public class Randoms {
    public static int min_maxBoundedInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
