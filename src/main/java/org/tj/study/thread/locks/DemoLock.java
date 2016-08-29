package org.tj.study.thread.locks;

import sun.awt.Mutex;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001 on 16/8/24.
 */
public class DemoLock implements Runnable{

//    List<String> list = new ArrayList<>();
    int i = 0;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
//        list.add("");
//        lock.lock();
//        synchronized (this){
//            try {
                i++;
//            }finally {
    //            lock.unlock();
//            }
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j=0;j<20;j++){
//            AbstractQueuedSynchronizer;
//            Lock;
//            ReentrantLock
//            HashMap
            DemoLock demoLock = new DemoLock();
            Thread[] threads = new Thread[1000];
            for (int i=0;i<1000;i++){
                threads[i] = new Thread(demoLock);
            }
            for (int i=0;i<1000;i++){
                threads[i].start();
            }
            Thread.sleep(1);
            System.out.println(demoLock.i);
        }

    }
}
