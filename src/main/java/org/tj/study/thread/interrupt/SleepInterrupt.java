package org.tj.study.thread.interrupt;

/**
 * Created by 001 on 16/8/1.
 */
public class SleepInterrupt implements Runnable{


    @Override
    public void run() {
        try {
            System.out.println("Thread sleep 20 seconds");
            Thread.sleep(20000);
//            Vector
            System.out.println("woke up");
        } catch (InterruptedException e) {
//            System.out.println(in);
            e.printStackTrace();
        }
    }
}
