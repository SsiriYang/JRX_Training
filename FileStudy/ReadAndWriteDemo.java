package com.codeyang.jrxtraining.FileStudy;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @Author 41765
 * @Creater 2020/5/20 23:29
 * Description
 */
public class ReadAndWriteDemo {
    /**
     * DOC 读取信息.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static int read(String path) throws FileNotFoundException, IOException {
        // 指定要读取的文件
        File file = new File(path);
        // 获得该文件的缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        // 用来保存每次读取一行的内容
        String line = "";
        long flag = 0;
        while ((line = bufferedReader.readLine()) != null) {
            flag = flag + 1;
            System.out.println(line);
        }
        bufferedReader.close();// 关闭输入流
        if(flag==100000){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * DOC 写入信息.
     *
     * @throws IOException
     */
    private static int write(String path) throws IOException {
        // 指定要写入的文件
        File file = new File(path);
        // 如果文件不存在则创建
        if (!file.exists()) {
            file.createNewFile();
        }
        // 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 写入信息
        for(int i = 0;i<100000;i++){
            bufferedWriter.write(i+"");
            // 表示换行
            bufferedWriter.newLine();
        }
        // 清空缓冲区
        bufferedWriter.flush();
        // 关闭输出流
        bufferedWriter.close();
        return 1;
    }
    public static int clearInfoForFile(String fileName) {
        File file =new File(fileName);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int writeRes = ReadAndWriteDemo.write("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\Demo.txt");
        System.out.println(writeRes>0?"写入完成":"写入失败");
        //阻塞
        String nextRead = sc.nextLine();
        int readRes = ReadAndWriteDemo.read("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\Demo.txt");
        System.out.println(readRes>0?"读取完成":"读取出现错误");
        //阻塞
        String nextClean = sc.nextLine();
        int cleanRes = ReadAndWriteDemo.clearInfoForFile("E:\\JavaSourceLearn\\src\\com\\codeyang\\jrxtraining\\FileStudy\\Demo.txt");
        System.out.println(cleanRes>0?"清空完成":"清空失败");
    }
}
