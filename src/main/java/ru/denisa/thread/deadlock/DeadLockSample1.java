package ru.denisa.thread.deadlock;

/**
 * Created by root on 04/11/18.
 * <p>
 * Thread1 captured aObj and wait bObj
 * Thread2 captured bObj and wait aObj
 * as result we have deadlock
 */
public class DeadLockSample1 {
    Object aObj=new Object();
    Object bObj=new Object();


    private Object captureAObj() throws InterruptedException {
        synchronized (aObj) {
            System.out.println("Wait in the captureAObj() AOBJ");
            aObj.wait(100);
            aObj.notify();

            synchronized (bObj) {
                System.out.println("Wait in the captureAObj() BOBJ");
                bObj.wait(100);
                bObj.notify();

            }


        }
        System.out.println("Going to the notify() captureAObj()");
        return aObj;
  }





    private Object captureBObj() throws InterruptedException {
        synchronized (bObj) {
            System.out.println("Wait in the captureBObj() BOBJ");
             bObj.wait(100);
             bObj.notify();

            synchronized (aObj) {
                System.out.println("Wait in the captureBObj AOBJ");
                aObj.wait(100);
                aObj.notify();

            }

        }
        System.out.println("Going to the notify() captureBObj");
        return bObj;
    }


    public static void main(String[] args) {
        DeadLockSample1 deadLockSample1 = new DeadLockSample1();

        Runnable task1A = () -> {
            try {
                deadLockSample1.captureAObj();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };


        Runnable taskB = () -> {
            try {
                deadLockSample1.captureBObj();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };
        Thread threadA = new Thread(task1A);
        threadA.start();

      Thread threadB = new Thread(taskB);
        threadB.start();

    }

    ;


}




