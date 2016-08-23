package org.tj.study.thread.join;

import org.tj.study.thread.ticket.one.ThreadA;

/**
 * Created by 001 on 16/8/23.
 */
public class DemoJoin implements Runnable{

    Thread thread;

    public DemoJoin(Thread thread){
        this.thread = thread;
    }

    public static void main(String[] args) {
        Thread thread1 = Thread.currentThread();
        Thread threadA = new Thread(new DemoJoin(thread1),"A");
        Thread threadB = new Thread(new DemoJoin(threadA),"B");
        Thread threadC = new Thread(new DemoJoin(threadB),"C");
        Thread threadD = new Thread(new DemoJoin(threadC),"D");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
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
