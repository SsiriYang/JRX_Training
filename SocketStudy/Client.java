package com.codeyang.jrxtraining.SocketStudy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/5/21 12:34
 * Description
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("192.168.5.1",9999);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        for(;;){
            String s = dis.readUTF();
            System.out.println("客户端:"+s);
            String str = input.nextLine();
            dos.writeUTF(str);
        }
    }
}
