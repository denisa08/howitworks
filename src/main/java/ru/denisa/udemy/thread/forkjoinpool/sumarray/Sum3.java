package ru.denisa.udemy.thread.forkjoinpool.sumarray;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by root on 09/12/18.
 */
public class Sum3 extends RecursiveTask<Long>{
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
            Sum3 left=new Sum3(array,low,mid);
            Sum3 right=new Sum3(array,mid,high);
            invokeAll(left,right);

            long rightAns=left.join();
            long leftAns = right.join();
            return leftAns+rightAns;
        }

    }


    Sum3(int[] arr, int lo, int hi){
        array=arr;
        low=lo;
        high=hi;
    }




    public static long sumArray(int[] array){
        return ForkJoinPool.commonPool().invoke(new Sum3(array,0,array.length));
    }





}
