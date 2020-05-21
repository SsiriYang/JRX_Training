package com.codeyang.jrxtraining.SocketStudy.ThreadSocket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.5.1",9999);
		ThreadRead t =new ThreadRead(socket);
		t.start();
		ThreadWrite t1 = new ThreadWrite(socket,"客户端");
		t1.start();
	}
}
