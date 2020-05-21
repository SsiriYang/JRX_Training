package com.codeyang.jrxtraining.SocketStudy.ThreadSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadRead extends Thread {
	private Socket socket;

	public ThreadRead(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while (true) {
				System.out.println(dis.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
