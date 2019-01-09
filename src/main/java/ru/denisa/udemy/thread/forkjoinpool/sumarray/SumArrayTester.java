package ru.denisa.udemy.thread.forkjoinpool.sumarray;

/**
 * Created by root on 09/12/18.
 */
public class SumArrayTester {

    public static  void main (String[] args){
        int arr[] = new int [10001];

        for (int i =1;i<10001;i++){
            arr[i]=i;
         }

       long result =  Sum1.sumArray(arr);
       System.out.println("arrSum = "+result); //result must be 50005000

        long result2 =  Sum2.sumArray(arr);
        System.out.println("arrSum = "+result2); //result must be 50005000


        long result3 =  Sum3.sumArray(arr);
        System.out.println("arrSum = "+result3); //result must be 50005000


    }




}
