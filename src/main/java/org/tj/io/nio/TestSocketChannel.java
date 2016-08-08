package org.tj.io.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by 001 on 16/8/4.
 */
public class TestSocketChannel {

    public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("10.10.1.183",8080));

            if(socketChannel.finishConnect()){
                int i = 0;
                while (true){
                    TimeUnit.SECONDS.sleep(1000);
                    String info = i++ +" -th information from client";
                    buffer.clear(); //position = 0 limit  = capacity
                    buffer.put(info.getBytes()); //position = info.getBytes().length  limit = capacity
                    buffer.flip(); // position = 0, limit  = position
                    while (buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (socketChannel != null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void server(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080,0,InetAddress.getLocalHost());
            System.out.println(serverSocket.getInetAddress());
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while (true){
                Socket clientScoket = serverSocket.accept();
                SocketAddress clentAddress = clientScoket.getLocalSocketAddress();
                System.out.println("Handing client at "+clentAddress);
                InputStream inputStream = clientScoket.getInputStream();
                while ((recvMsgSize = inputStream.read(recvBuf)) != -1){
                    System.out.println(new String(recvBuf));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        server();
        client();
    }
}
