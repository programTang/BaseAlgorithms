package org.tj.study.thread.readfile;

import java.io.*;

/**
 * Created by 001 on 16/8/22.
 */
public class ReadFile implements Runnable{

    int sum = 0;
    BufferedReader bufferedReader;
    String str;

    public ReadFile(String filename){
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void readfile(String fileName) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File(fileName)));
        int sum = 0;
        String str;
        while ((str = bufferedReader1.readLine())!=null){
            sum += Integer.valueOf(str);
        }

    }

    public static void main(String[] args) throws IOException {

        for (int i=0;i<8;i++){
            long start = System.currentTimeMillis();
            readfile("thread1.txt");
            readfile("thread2.txt");
            System.out.println("单线程耗时: "+(System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            ReadFile readFile1 = new ReadFile("thread1.txt");
            ReadFile readFile2 = new ReadFile("thread2.txt");
            Thread thread1 = new Thread(readFile1);
            Thread thread2 = new Thread(readFile2);
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("多线程耗时: "+(System.currentTimeMillis() - start));
//            System.gc();
        }


    }


    @Override
    public void run() {
        try {
            while ((str = bufferedReader.readLine())!=null){
                sum += Integer.valueOf(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
