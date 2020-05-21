package com.codeyang.jrxtraining.ExceptionStudy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * @Author 41765
 * @Creater 2020/5/15 0:08
 * Description
 */
public class throwsDemo {
    //异常的一种处理方式
    public static void main(String[] args) throws UnknownHostException, IOException {
        //socket通信要捕捉UnknownHostException和IOException
        Socket socket = new Socket("192.168.1.5",8888);
    }

}
