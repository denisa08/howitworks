package ru.denisa.udemy.thread.pool.counters;

/**
 * Created by root on 28/10/18.
 */
public class Counters {

    private int c=0;

    public void increment(){
        c++;
    }

    public void derement(){
        c--;
    }


    public int value(){
        return c;
    }






}
