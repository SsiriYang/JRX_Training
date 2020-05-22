package com.codeyang.jrxtraining.FileStudy.IOStudy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			File file = new File("E:\\JAVA02\\20190331\\aa.txt");
			fr = new FileReader(file);

			int c=-1;
			while((c=fr.read())!=-1){
				System.out.print((char)c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null){
					fr.close();//关闭流
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
