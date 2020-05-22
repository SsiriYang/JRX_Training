package com.codeyang.jrxtraining.SocketStudy;

import com.codeyang.jrxtraining.CollectionStudy.CollectionDemo.LinkedListTest;
import com.codeyang.jrxtraining.FileStudy.ReadAndWriteDemo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 41765
 * @Creater 2020/5/21 12:00
 * Description
 */
public class WebpageSocket {
    public static void main(String[] args) throws Exception{
        Socket s=new Socket(InetAddress.getByName("47.98.178.173"),8080);
        //可以理解成request请求，想服务器发送数据

        OutputStream os=s.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw=new BufferedWriter(osw);

        //编辑请求头，也就是请求参数，这是最基本的 正常请求会带好多参数
        bw.write("GET / HTTP/1.1\r\n");
        bw.write("Connection: Keep-Alive\r\n");
        bw.write("Host: 47.98.178.173\r\n");
        bw.write("Connection: Keep-Alive\r\n\r\n");
        bw.flush();
        //关闭客户端的输出流
        s.shutdownOutput();
        //response响应
        InputStream is=s.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String str=null;
        LinkedList<String> content = new LinkedList<String>();
        while((str=br.readLine())!=null){
            System.out.println(str);
            content.add(str);
        }
        //奇怪的问题出现了，我们是东八区，响应的报文头可以看出服务器时间比我们的慢8个小时，
        //GMT指的是格林威治中央区时（0区）
        //北京时间=GMT时间+8小时。
        ReadAndWriteDemo.writesome("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\SocketStudy\\out.txt",content);
        s.close();
    }
}
