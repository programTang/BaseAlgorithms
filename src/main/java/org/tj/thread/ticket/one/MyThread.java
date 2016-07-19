package org.tj.thread.ticket.one;

/**
 * Created by 001 on 16/6/13.
 */
public class MyThread implements Runnable{

    private int ticket = 5;
    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println(name+" ticket: "+ ticket--);
            }
        }
    }

    public static void main(String[] args) {

//        new Thread(new MyThread("A")).start();
//        new Thread(new MyThread("B")).start();
//        new Thread(new MyThread("C")).start();
    }
}
