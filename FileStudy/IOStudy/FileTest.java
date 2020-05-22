package com.codeyang.jrxtraining.FileStudy.IOStudy;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

		File file = new File("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\IOStudy");
		//文件的大写以字节个数表示
		System.out.println(file.length());
		//文件名
		System.out.println(file.getName());
		//判断是否是一个文件
		System.out.println(file.isFile());
		//判断是否是一个文件夹
		System.out.println(file.isDirectory());
		//判断文件是否存在
		System.out.println(file.exists());
		//file.createNewFile();//创建文件
		//file.mkdir();//创建文件夹
		//获取上级目录
		File parent = file.getParentFile();
		System.out.println(parent.getName());

		System.out.println("================");
		//获取孩子
		File[] files = file.listFiles();
		for(File ff : files){
			System.out.println(ff.getName() +"  "+(ff.isFile()?"文件":"文件夹"));
		}

	}

}
