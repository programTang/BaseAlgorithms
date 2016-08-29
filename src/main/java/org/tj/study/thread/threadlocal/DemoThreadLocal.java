package org.tj.study.thread.threadlocal;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001 on 16/8/23.
 */
public class DemoThreadLocal {
    Long signal = Long.valueOf(1);
    ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public Long getSignal() {
        return signal;
    }

    public void setSignal(long signal) {
        this.signal = signal;
    }

    public Long getThreadLocal() {
        return threadLocal.get();
    }

    public void setThreadLocal(long local) {
        this.threadLocal.set(local);
    }

    public static void main(String[] args) throws InterruptedException {
        DemoThreadLocal demoThreadLocal = new DemoThreadLocal();
        demoThreadLocal.setSignal(1);
        demoThreadLocal.setThreadLocal(1);
//        ReentrantLock
        System.out.println(Thread.currentThread().getName()+" "+demoThreadLocal.getSignal()+"  "+demoThreadLocal.getThreadLocal());

        Thread thread = new Thread(()->{
            demoThreadLocal.setSignal(2);
            demoThreadLocal.setThreadLocal(2);
            System.out.println(Thread.currentThread().getName()+" "+demoThreadLocal.getSignal()+"  "+demoThreadLocal.getThreadLocal());
        });

        thread.start();
        thread.join();
        System.out.println(Thread.currentThread().getName()+" "+demoThreadLocal.getSignal()+"  "+demoThreadLocal.getThreadLocal());


    }
}
