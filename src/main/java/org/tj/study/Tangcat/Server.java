package org.tj.study.Tangcat;

import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by 001 on 16/11/25.
 */
public class Server {

    int PORT = 8090;

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        ApplicationContext
        Server server = new Server();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new HandlerThread(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        public void run() {
            try {
                // 读取客户端数据
//                DataInputStream input = new DataInputStream(socket.getInputStream());
//                String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
                // 处理客户端数据
                byte[] buf = new byte[1024*1024];
                InputStream in = socket.getInputStream();
                int byteRead = in.read(buf, 0, 1024*1024);
                String dataString = new String(buf, 0, byteRead);
//                System.out.println(dataString);
                System.out.println("客户端发过来的内容:" + dataString);

                // 向客户端回复信息
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.print("请输入:\t");
                // 发送键盘输入的一行

                //发送回浏览器的内容
                String response = "";
                response += "HTTP/1.1 200 OK\n";
//                response += "Server: Sunpache 1.0\n";
                response += "Content-Type: text/html\n";
//                response += "Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT\n";
//                response += "Accept-ranges: bytes\n";
                response += "\n";
//                String body = "<html><head><title>test server</title></head><body><p>post ok:</p></body></html>";
//                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
//                out.writeUTF(response+body);
                out.writeUTF(response);

                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
