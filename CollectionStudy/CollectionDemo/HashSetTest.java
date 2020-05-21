package com.codeyang.jrxtraining.CollectionStudy.CollectionDemo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author 41765
 * @Creater 2020/5/14 18:34
 * Description
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("王五");
        //打印当前set的size
        System.out.println(hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        for (String name : hashSet) {    //输出set集合中的元素
            System.out.println(name);
        }
        Boolean res = hashSet.add("王五");
        System.out.println("插入重复元素结果："+res);
    }
}
