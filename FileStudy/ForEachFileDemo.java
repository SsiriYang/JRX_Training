package com.codeyang.jrxtraining.FileStudy;

import java.io.File;

/**
 * @Author 41765
 * @Creater 2020/5/20 23:12
 * Description
 */
public class ForEachFileDemo {
    private static void func(File file) {

        File[] fs = file.listFiles();
        for (File f : fs) {
            //若是目录，则递归打印该目录下的文件
            if (f.isDirectory()){
                func(f);
            }
            //若是文件，直接打印
            if (f.isFile()) {
                System.out.println(f);
            }
        }
    }
    public static void main(String[] args) {
        //要遍历的路径
        String inputPath = "E:\\VUE";;
        //获取其file对象
        File file = new File(inputPath);
        func(file);
    }
}
