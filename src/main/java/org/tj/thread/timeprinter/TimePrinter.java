package org.tj.thread.timeprinter;
import java.util.*;

/**
 * Created by 001 on 16/6/13.
 */
class TimePrinter
        implements Runnable {
    int pauseTime;
    String name;
    public TimePrinter(int x, String n) {
        pauseTime = x;
        name = n;
    }
    public void run() {
        while(true) {
            try {
                System.out.println(name + ":" + new
                        Date(System.currentTimeMillis()));
                Thread.sleep(pauseTime);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    static public void main(String args[]) {
        Thread t1 = new Thread (new TimePrinter(1000, "Fast Guy"));
        t1.start();
        Thread t2 = new Thread (new TimePrinter(3000, "Slow Guy"));
        t2.start();

    }
}