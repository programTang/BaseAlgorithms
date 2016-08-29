package org.tj.study.thread.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 001 on 16/8/24.
 */
public class DemoSemaphore {

    private static final int THREAD_COUNT = 30;
    private static Executor threadPool =Executors
            .newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);


    public static void main(String[] args) {
        for (int i = 0; i< THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }
//        threadPool.();
    }

}
