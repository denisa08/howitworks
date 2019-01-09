package ru.denisa.udemy.thread.forkjoinpool;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by root on 05/12/18.
 */
public class MathUtils {

    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();



    /** Marks each entry i with true or false depending on

     *  whether i is prime or not. Serial version that

     *  marks from one index to the other (inclusive).

     */

    public static void markPrimesSerial(boolean[] primeFlags,

                                        int lowerIndex, int upperIndex) {

        for (int i=lowerIndex; i<=upperIndex; i++) {

            primeFlags[i] = Primes.isPrime( BigInteger.valueOf(i));

        }

    }


    /** Marks each entry i with true or false depending on

     *  whether i is prime or not. Serial version that

     *  marks all entries in the array.

     */

    public static void markPrimesSerial(boolean[] primeFlags) {

        markPrimesSerial(primeFlags, 0, primeFlags.length-1);

    }


    /** Marks each entry i with true or false depending on

     *  whether i is prime or not. Parallel version that

     *  marks all entries in the array.

     */

    public static void markPrimesParallel(boolean[] primeFlags) {

        FORK_JOIN_POOL.invoke(new ParallelPrimeMarker(primeFlags, 0, primeFlags.length-1));

    }


    /** Given an already-marked boolean[] of flags that says

     *  whether each index is prime or not, produces a List

     *  of the primes. Used by both the serial and parallel versions.

     */

    public static List<Integer> collectPrimes(boolean[] primeFlags) {

        List<Integer> primes = new ArrayList<>();

        for(int i=0; i<primeFlags.length; i++) {

            if (primeFlags[i]) {

                primes.add(i);

            }

        }

        return(primes);

    }


    public static List<Integer> findPrimesSerial(boolean[] primeFlags) {

        markPrimesSerial(primeFlags);

        return(collectPrimes(primeFlags));

    }


    /** Uses findPrimesSerial(booleanArray) to produce a List of primes

     *  less than the given size. */



    public static List<Integer> findPrimesSerial(int size) {

        boolean[] primeFlags = new boolean[size];

        return(findPrimesSerial(primeFlags));

    }



    /** Given an unmarked boolean[] of flags, marks each one in parallel, saying

     *  whether the index is prime or not, then passes that array

     *  to collectPrimes to produce a List of primes. The version where

     *  you pass in the array (here) was split into a separate method so that,

     *  for timing purposes, you can separate the time of making the array

     *  from the time of marking it.

     */



    public static List<Integer> findPrimesParallel(boolean[] primeFlags) {

        markPrimesParallel(primeFlags);

        return(collectPrimes(primeFlags));

    }


    /** Uses findPrimesParallel(booleanArray) to produce a List of primes

     *  less than the given size. */



    public static List<Integer> findPrimesParallel(int size) {

        boolean[] primeFlags = new boolean[size];

        return(findPrimesParallel(primeFlags));

    }


    public static void main(String[] args) {

        int size;

        try {

            size = Integer.parseInt(args[0]);

        } catch (Exception e) { // No args or illegal arg.

            size = 100;

        }

        List<Integer> primes = findPrimesSerial(size);

        System.out.printf("Primes less than %s:%n", size);

        for(Integer prime: primes) {

            System.out.println(prime);

        }

    }


    private MathUtils() {} // Uninstantiatable class: only static methods



}
