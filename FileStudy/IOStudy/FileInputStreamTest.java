package com.codeyang.jrxtraining.FileStudy.IOStudy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy\\cc.bmp");
			fos = new FileOutputStream("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy\\dd.bmp");

			int c=-1;
			//512  1024  缓冲
			byte[] b=new byte[1024];
			while((c=fis.read(b))!=-1){
				fos.write(b,0,c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
