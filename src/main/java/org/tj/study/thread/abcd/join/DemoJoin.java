package org.tj.study.thread.abcd.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by 001 on 16/8/23.
 */
public class DemoJoin implements Runnable{

//    threadX.join  代表当前线程要等待X线程结束才能从join中返回继续执行

    Thread thread;

    public DemoJoin(Thread thread){
        this.thread = thread;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = Thread.currentThread();
        Thread threadA = new Thread(new DemoJoin(thread1),"A");
        Thread threadB = new Thread(new DemoJoin(threadA),"B");
        Thread threadC = new Thread(new DemoJoin(threadB),"C");
        Thread threadD = new Thread(new DemoJoin(threadC),"D");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
