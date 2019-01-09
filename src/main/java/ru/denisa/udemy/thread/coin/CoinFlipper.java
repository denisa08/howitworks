package ru.denisa.udemy.thread.coin;

/**
 * Created by root on 28/11/18.
 */
public class CoinFlipper implements  Runnable {

    @Override
    public void run() {
        int numHeads=0;
        for (int i=0;i<1000;i++){
            double coin = Math.random();

            if (coin < 0.5) {
                    numHeads = numHeads + 1;

            } else {
               numHeads = 0;
             }

            if (numHeads >= 3) {
                System.out.printf("%s got %d heads in a row.%n",Thread.currentThread().getName(),numHeads);

            }

        }
   }
 }
