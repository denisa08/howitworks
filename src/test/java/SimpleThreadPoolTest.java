import ru.denisa.thread.pool.SimpleThreadpool;

import java.util.concurrent.TimeoutException;

import static java.lang.Thread.sleep;

/**
 * Created by root on 20/10/18.
 */
public class SimpleThreadPoolTest {

    public static void main (String[] args) throws InterruptedException, TimeoutException {


    SimpleThreadpool simpleThreadpool = SimpleThreadpool.getInstance(2);

        Runnable task1 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Simple task" + threadName);
        };


        Runnable task2 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Infinitive task" + threadName);




        };

        Runnable task3 = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("  task 3" + threadName);




        };

        simpleThreadpool.execute(task1);
      simpleThreadpool.execute(task2);
        simpleThreadpool.execute(task3);




        // System.out.println("Attend to terminate thread pool");
      //  simpleThreadpool.stop();







    }



}
