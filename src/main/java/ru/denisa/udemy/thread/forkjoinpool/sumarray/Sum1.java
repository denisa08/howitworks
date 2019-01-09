package ru.denisa.udemy.thread.forkjoinpool.sumarray;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by root on 09/12/18.
 */
public class Sum1 extends RecursiveTask<Long>{
    static final int SEQUENTAL_THRESHOLD=5000;

    int low, high;
    int [] array;

    @Override
    protected Long compute() {


     if (high-low<=SEQUENTAL_THRESHOLD){
         long sum=0;
         for (int i=low;i<high;++i){
             sum+=array[i];
          }
         return sum;
      }else{
         int mid=low+(high-low)/2;
         Sum1 left=new Sum1(array,low,mid);
         Sum1 right=new Sum1(array,mid,high);
         left.fork();
         long rightAns=right.compute();
         long leftAns = left.join();
         return leftAns+rightAns;
        }

    }


    Sum1(int[] arr, int lo, int hi){
        array=arr;
        low=lo;
        high=hi;
     }




    public static long sumArray(int[] array){
         return ForkJoinPool.commonPool().invoke(new Sum1(array,0,array.length));
    }





}
