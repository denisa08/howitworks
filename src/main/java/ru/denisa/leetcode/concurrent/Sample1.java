package leetcode.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Sample1 {


    public static void main(String[] args) {

        Sample1 sample1 = new Sample1();
        Runnable one = sample1::first;
        Runnable rwoo = sample1::second;
        Runnable three = sample1::third;
        new Thread(one).start();
        new Thread(rwoo).start();
        new Thread(three).start();


    }


    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void first() {

        while(atomicInteger.get()!=0){}

           if (atomicInteger.get()==0){
               System.out.println("first");
               atomicInteger.incrementAndGet();
           }




    }

    public void second() {
        while(atomicInteger.get()!=1){

        }
            if (atomicInteger.get()==1){
                System.out.println("second");
                atomicInteger.incrementAndGet();
            }



   }

    public void third() {
        while(atomicInteger.get()!=2){

        }
            if (atomicInteger.get()==2){
                System.out.println("third");
                atomicInteger.incrementAndGet();
            }


    }




}
