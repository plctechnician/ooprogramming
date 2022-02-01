package oop.basics;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomNumbers {
    public static void main(String[] args) {
        int seed = 42;
        RandomGenerator rnd = new Random(seed);
        //RandomGenerator rnd = RandomGeneratorFactory.of("Random").create(seed);
        //RandomGenerator rnd = RandomGeneratorFactory.getDefault().create(seed);
        //RandomGenerator rnd = RandomGeneratorFactory.of("L32X64MixRandom").create(seed);
        //RandomGenerator rnd = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create(seed);

        /* integer numbers */
        System.out.println(rnd.nextInt());
        System.out.println(rnd.nextLong());

        /* floating point numbers */
        System.out.println(rnd.nextFloat());
        System.out.println(rnd.nextDouble());

        /* boolean values */
        System.out.println(rnd.nextBoolean());
    }
}
