package org.tj.study.thread.locks;

import java.util.concurrent.locks.Lock;

/**
 * Created by 001 on 16/8/24.
 */
public class TestTwinsLock {

    static Lock lock = new TwinsLock();


    public TestTwinsLock(Lock lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {


        class Worker implements Runnable{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                        System.out.print(Thread.currentThread().getName() + "  ");
                        Thread.sleep(1000);
                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }
//// 每隔1秒换行
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            System.out.println();
//        }
    }
}
