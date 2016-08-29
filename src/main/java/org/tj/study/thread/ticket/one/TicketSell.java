package org.tj.study.thread.ticket.one;

/**
 * Created by 001 on 16/8/1.
 */
public class TicketSell implements Runnable {

    private int remian = 799;

    public  void sellTicket() throws InterruptedException {
            while (remian>0){
                synchronized(this){
//                    System.out.println(remian);
//                    System.out.println(remian%8);
                    if (remian>0 && remian%8!=0){
//                    if (remian>0){
                        System.out.println(Thread.currentThread().getName() + " 正在出售第 " + remian-- + " 票");
                        this.wait();
                        System.out.println(Thread.currentThread().getName() + " 被唤醒");
                    }else {
                        System.out.println(Thread.currentThread().getName() + " 正在出售第 " + remian-- + " 票");
                        remian--;
                        this.notifyAll();
                    }
                }
            }
    }


    @Override
    public void run() {
        try {
            sellTicket();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TicketSell ticketSell = new TicketSell();
        Thread[] threads = new Thread[9];
        for (int i=0;i<9;i++){
            threads[i] = new Thread(ticketSell,String.valueOf(i));
//            threads[i].setPriority(i+1);
        }
        for (int i=0;i<threads.length;i++){
            threads[i].start();
        }
    }
}
