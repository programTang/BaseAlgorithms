package org.tj.thread.ticket.one;

/**
 * Created by 001 on 16/6/13.
 */
public class MyThread implements Runnable{

    private int ticket = 15;
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public  void run() {
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println(Thread.currentThread()+" ticket: "+ ticket--);
            }
        }
    }

    public static void main(String[] args) {
        MyThread a = new MyThread("A");

        new Thread(a).start();
        new Thread(a).start();
        new Thread(a).start();
    }
}
