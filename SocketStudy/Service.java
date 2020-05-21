package com.codeyang.jrxtraining.SocketStudy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/5/21 12:35
 * Description
 */
public class Service {
    public static void main(String[] args) throws IOException {
        //创建socket对象，绑定9999端口
        ServerSocket server = new ServerSocket(9999);
        //阻塞效果等待连接
        Socket socket = server.accept();
        System.out.println("有弟弟连上了");
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        Scanner input = new Scanner(System.in);
        while(true){
            String out = input.nextLine();
            dos.writeUTF("服务端:"+out);
            //阻塞
            String s = dis.readUTF();
            System.out.println(s);
        }
    }
}
