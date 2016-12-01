package org.tj.study.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 001 on 16/8/3.
 */
public class TestFilecChannel {

    static void readTxtFileChannel() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/fahai/Desktop/BaseAlgorithms/src/main/resources/test.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(11);
        byte[] bytes = new byte[1024];
//        int bytesRead = fileChannel.read(byteBuffer);
        int bytesRead ;
        int start = 0;
        while ((bytesRead = fileChannel.read(byteBuffer)) != -1){
//            System.out.println("Read " + bytesRead);
//            byteBuffer.flip();
//            System.arraycopy(byteBuffer.array(),0,bytes,start,bytesRead);
            System.out.println(new String(byteBuffer.array(), "utf-8"));
            start += bytesRead;
//            while (byteBuffer.hasRemaining()){
//                System.out.println((char)byteBuffer.get());
//            }
            byteBuffer.clear();
            byteBuffer.limit();
            byteBuffer.mark();
            byteBuffer.position();
//            bytesRead = fileChannel.read(byteBuffer);

        }
        System.out.println(new String(bytes,"utf-8"));

        fileChannel.close();

    }

    public static void main(String[] args) throws IOException {
        readTxtFileChannel();
    }
}
