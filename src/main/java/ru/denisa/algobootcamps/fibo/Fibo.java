package algobootcamps.fibo;

public class Fibo {


    public static void main (String args[]){
        Fibo fibo = new Fibo();
        System.out.println(fibo.fib(7));


    }



   public  int fib (int n){

       if (n<=0){
           return 0;
       } else if (n==1){
           return 1;
       } else{
           return fib(n-1)+fib (n-2);
       }




   }



}
