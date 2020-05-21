package com.codeyang.jrxtraining.SocketStudy.ThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadService {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		//阻塞效果等待连接
		Socket socket = server.accept();
		ThreadRead t = new ThreadRead(socket);
		t.start();
		System.out.println("客户端已上线");
		ThreadWrite t1 = new ThreadWrite(socket,"服务端");
		t1.start();
	}
}
