package org.tj.study.thread.ticket.one;

/**
 * Created by 001 on 16/7/29.
 */
public class ThreadA implements Runnable{

    private int i = 0;
    private String name;

    public ThreadA(){
    }

    public ThreadA(String name){
        this.name = name;
    }

    @Override
    public  void run() {
        while (i<100){
//            synchronized (this){
                System.out.println(Thread.currentThread().getName()+":" + i++);
//            }
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadA b = new ThreadA("b");
        ThreadA c = new ThreadA("c");
        Thread threadA = new Thread(a,"a");
        Thread threadB = new Thread(b,"b");
        Thread threadC = new Thread(c,"c");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
