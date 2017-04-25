package multiples;

/**
 * Created by nicola on 11/04/17.
 */
public class Multiples {

    //Lazy and inefficient way
    public int sumMultiples(int bound) {
        int sum = 0;
        for (int i = 0; i < bound; i++)
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        return sum;
    }

    //Improved algorithm
    public int sumMultiples_improved(int bound) {
        int sum = 0;
        return 0;
    }
}
