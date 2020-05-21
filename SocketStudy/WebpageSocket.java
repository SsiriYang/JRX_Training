package com.codeyang.jrxtraining.SocketStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Author 41765
 * @Creater 2020/5/21 12:00
 * Description
 */
public class WebpageSocket {
    private static int port = 80;
    private static String hostname = "www.baidu.com";
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket(hostname, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        writer.write("GET " + "/ask" + " HTTP/1.0\r\n");
        writer.write("HOST:" + hostname + "\r\n");
        writer.write("Accept:*/*\r\n");
        writer.write("\r\n");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        writer.close();
        socket.close();
    }
}
