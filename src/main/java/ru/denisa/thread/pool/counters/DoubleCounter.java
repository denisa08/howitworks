package ru.denisa.thread.pool.counters;

import ru.denisa.thread.pool.ExecutorThreadPool;
import ru.denisa.thread.pool.SimpleThreadpool;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by root on 26/10/18.
 */
public class DoubleCounter {

public static void main (String[] args){

    ExecutorThreadPool threadPool  = new ExecutorThreadPool(2);
    Counter counter = new Counter();
    long start = System.nanoTime();

    ArrayList<Future<Double>> futures = new ArrayList<>();



    for (int i = 0; i < 400; i++) {
        final int j = i;
        futures.add(
                CompletableFuture.supplyAsync(
                        () -> counter.count((double) j),
                        threadPool
                ));
    }




}




}
