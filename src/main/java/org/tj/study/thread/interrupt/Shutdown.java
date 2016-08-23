package org.tj.study.thread.interrupt;

import org.tj.study.thread.ticket.one.ThreadA;

import java.util.concurrent.TimeUnit;

/**
 * Created by 001 on 16/8/23.
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runner(),"interrupt");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread1.interrupt();

        Runner runner = new Runner();
        Thread thread2 = new Thread(runner,"flag");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        runner.setFlag(false);

    }


    static private class Runner implements Runnable{

        volatile boolean flag = true;
        private long i;

        @Override
        public void run() {
            while (flag && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println(i);
        }

        public void setFlag(boolean flag){
            this.flag = flag;
        }
    }
}

