package com.codeyang.jrxtraining.FileStudy.IOStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy\\aa.txt"));
			//System.out.println(br.readLine());
			//System.out.println(br.readLine());
			bw = new BufferedWriter(new FileWriter("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy\\bb.txt"));
			String line=null;
			while((line=br.readLine())!=null){
				bw.write(line+"\r\n");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null){
					br.close();
				}

				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
