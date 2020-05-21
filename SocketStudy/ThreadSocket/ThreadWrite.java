package com.codeyang.jrxtraining.SocketStudy.ThreadSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ThreadWrite extends Thread {
	private Socket socket;
	private String name;
	public ThreadWrite(Socket socket,String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner input = new Scanner(System.in);
			while (true) {
				String str = input.nextLine();
				dos.writeUTF(name+":"+str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
