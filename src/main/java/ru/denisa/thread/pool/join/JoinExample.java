package ru.denisa.thread.pool.join;

/**
 * Created by root on 28/10/18.
 */
public class JoinExample {

    public static void main (String[] args){

    Thread t1 = new Thread(
           () -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Simple task" + threadName);  }, "t1");

        Thread t2= new Thread(
                () -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Simple task" + threadName);
                    try {
                        Thread.currentThread().interrupt();
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Simple task" + threadName+" after InterruptedException");


                }, "t2");

            t1.start();



            try{
                t1.join();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
             t2.start();
          // t2.interrupt();
              System.out.println("is t2 is interrupted?: "+t2.isInterrupted());




}







}
