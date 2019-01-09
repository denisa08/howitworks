package ru.denisa.udemy.thread.forkjoinpool;

/**
 * Created by root on 06/12/18.
 */

import java.math.BigInteger;


/** Checks if a number (int, long, or BigInteger) "is" prime,

 *  which really means is probably prime (at most 1 in 2^100 chance

 *  of being wrong).

 */



public class Primes {



    // Likelihood of false prime is less than 1/2^ERR_VAL.

    // Presumably BigInteger uses the Miller-Rabin test or

    // equivalent, and thus is NOT fooled by Carmichael numbers.

    // See Cormen et al.'s Introduction to Algorithms for details.

    private static final int ERR_VAL = 100;



    public static boolean isPrime(BigInteger num) {

        return(num.isProbablePrime(ERR_VAL));

    }
    private Primes() {} // Uninstantiatable class
}
