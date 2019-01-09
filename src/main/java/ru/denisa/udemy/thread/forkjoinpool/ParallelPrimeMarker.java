package ru.denisa.udemy.thread.forkjoinpool;

import java.util.concurrent.RecursiveTask;

/**
 * Created by root on 05/12/18.
 */
public class ParallelPrimeMarker extends RecursiveTask<Void>  {


    private static final int PARALLEL_CUTOFF = 10;

    private boolean[] primeFlags;

    private int lowerIndex, upperIndex;


    public ParallelPrimeMarker(boolean[] primeFlags, int lowerIndex, int upperIndex) {

        this.primeFlags = primeFlags;

        this.lowerIndex = lowerIndex;

        this.upperIndex = upperIndex;

    }




    protected Void compute() {

        int range = upperIndex - lowerIndex;

        if (range <= PARALLEL_CUTOFF) {

            MathUtils.markPrimesSerial(primeFlags, lowerIndex, upperIndex);

        } else {

            int middleIndex = lowerIndex + range/2;

            ParallelPrimeMarker leftMarker =

                    new ParallelPrimeMarker(primeFlags, lowerIndex, middleIndex);

            ParallelPrimeMarker rightMarker =

                    new ParallelPrimeMarker(primeFlags, middleIndex+1, upperIndex);

            leftMarker.fork();

            rightMarker.compute();

            leftMarker.join();

        }

        return(null);

    }



}
