package com.codeyang.jrxtraining.FileStudy.IOStudy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			File file = new File("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy\\bb.txt");
			fw = new FileWriter(file);
			fw.write("你好，我是tom");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fw!=null){
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
