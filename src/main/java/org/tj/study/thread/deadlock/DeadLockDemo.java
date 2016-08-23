package org.tj.study.thread.deadlock;

import org.tj.study.thread.ticket.one.ThreadA;

/**
 * Created by 001 on 16/8/22.
 */
public class DeadLockDemo {
//    死锁  让A等待B B等待A
    public String A = "A";
    public String B = "B";

    public static void main(String[] args) {
//        A线程拿了A的锁后休眠 如果此时B线程拿了B的锁 接下来就等待A对象的锁  醒来后等待B对象锁 此时互相等待。
//        for (int i=0;i<100;i++){
            new DeadLockDemo().deadLock();
//        }
    }

    public void deadLock(){
        Thread threadA = new Thread(() -> {
            synchronized (A){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("1");
                }
            }
        });

        Thread threadB = new Thread(()->{
           synchronized (B){
               synchronized (A){
                   System.out.println("2");
               }
           }
        });

        threadA.start();
        threadB.start();

    }
}
