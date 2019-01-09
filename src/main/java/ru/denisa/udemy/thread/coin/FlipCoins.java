package ru.denisa.udemy.thread.coin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by root on 05/12/18.
 */
public class FlipCoins {

    public static void main(String[] args) {

        int poolSize = 10;

        ExecutorService tasks = Executors.newFixedThreadPool(poolSize);

        for(int i=0; i<5; i++) {
             tasks.execute(new CoinFlipper());
        }

        tasks.shutdown();

    }

}
