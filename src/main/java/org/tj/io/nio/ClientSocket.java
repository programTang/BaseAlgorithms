package org.tj.io.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by 001 on 16/8/4.
 */
public class ClientSocket {
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
                    TimeUnit.SECONDS.sleep(1);
                    String info = i++ +" -th information from client";
                    buffer.clear(); //position = 0 limit  = capacity
                    buffer.put(info.getBytes()); //position = info.getBytes().length  limit = capacity
                    buffer.flip(); // position = 0, limit  = info.getBytes()
                    while (buffer.hasRemaining()){
                        System.out.println(buffer);
                        System.out.println(new String(buffer.array()));
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
    public static void main(String[] args) throws IOException {
        client();
////        Socket socket = new Socket("10.10.1.183",8080);
//        Socket socket = new Socket();
////        socket.connect(InetSocketAddress.createUnresolved("10.10.1.183",8080));
//        socket.connect(new InetSocketAddress("10.10.1.183",8080));
//
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("ssssss".getBytes());
//        outputStream.flush();
    }
}
