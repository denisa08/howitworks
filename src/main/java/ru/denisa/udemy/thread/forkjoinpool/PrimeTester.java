package ru.denisa.udemy.thread.forkjoinpool;

import java.util.*;


import static org.hamcrest.CoreMatchers.*;



/**
 * Created by root on 07/12/18.
 */
public class PrimeTester {

    /**
     * Compares timing of parallel and sequential versions. Compares timing only
     * <p>
     * for marking the boolean array, since the time to create the boolean array
     * <p>
     * and the time to build a List from the boolean array are shared by
     * <p>
     * both approaches.
     */

    public static void main(String[] args) {

        for (int i = 3; i < 8; i++) {

            int size = (int) Math.pow(10, i);

            String message1 = "Serial marking of   %,d numbers";

            String message2 = "Parallel marking of %,d numbers";


            boolean[] primeFlags = new boolean[size];

          TimingUtils.timeOp(() -> {

              MathUtils.markPrimesSerial(primeFlags);

              return (String.format(message1, size));

          });

            List<Integer> primes1 = MathUtils.collectPrimes(primeFlags);

         TimingUtils.timeOp(() -> {

             MathUtils.markPrimesParallel(primeFlags);

             return (String.format(message2, size));

         });

            List<Integer> primes2 = MathUtils.collectPrimes(primeFlags);

            System.out.printf("Serial version found %,d primes.%n", primes1.size());

            System.out.printf("Serial version found %,d as largest prime.%n", primes1.get(primes1.size() - 1));

            System.out.printf("Parallel version found %,d primes.%n", primes2.size());

            System.out.printf("Parallel version found %,d as largest prime.%n%n", primes2.get(primes2.size() - 1));

        }


    }
}