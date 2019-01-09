package ru.denisa.thread.pool.counters;

/**
 * Created by root on 26/10/18.
 */
public class Counter {


    public Double count(Double doublee){

        for (int i=0;i<10000;i++){
            doublee= Math.tan(doublee)+doublee;

        }

        return doublee;
    }


}
