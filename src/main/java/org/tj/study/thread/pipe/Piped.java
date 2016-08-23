package org.tj.study.thread.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by 001 on 16/8/23.
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);
        new Thread(new Print(reader),"reader1").start();
        int receive = 0;

        try {
            while ((receive = System.in.read()) != 0){
                writer.write(receive);
            }
        } finally {
            writer.close();
        }
    }


    static class Print implements Runnable{

        private PipedReader in;

        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != 0){
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
