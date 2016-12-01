package org.tj.study.io;

import java.io.*;

/**
 * Created by 001 on 16/8/2.
 */
public class BufferedIOExample {
    static String url  = "/Users/fahai/Desktop/BaseAlgorithms/src/main/resources/test.txt";

    public static void readTxt() throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(url));
        OutputStream outputStream = new BufferedOutputStream(new PrintStream(System.out));
        byte[] bytes = new byte[512];
        int length;
        while ((length = inputStream.read(bytes)) != -1){
            outputStream.write(bytes);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }

    public static void readTxtReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
        PrintWriter printWriter = new PrintWriter(System.out);
        char[] bytes = new char[512];
        int length;
        while ((length = bufferedReader.read(bytes)) != -1){
            printWriter.write(bytes,0,length);
//            printWriter.write(bytes);

        }
        printWriter.flush();
        printWriter.close();
    }




    public static void main(String[] args) throws IOException {
//        readTxt();
        readTxtReader();
    }
}
