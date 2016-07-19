package org.tj.thread.ticket.one;

/**
 * Created by 001 on 16/6/13.
 */
public class MyTicket extends Thread{

    private int ticket = 5;
    private String name;

    public MyTicket(String name){
        this.name = name;
    }

    @Override
    public  void run() {
        this.getName();
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println(name+" ticket: "+ ticket--);
            }
        }
    }

    public static void main(String[] args) {
        MyTicket ticketA = new MyTicket("A");
        MyTicket ticketB = new MyTicket("B");
        MyTicket ticketC = new MyTicket("C");
        ticketB.start();
        ticketC.start();
        ticketA.start();


    }
}
