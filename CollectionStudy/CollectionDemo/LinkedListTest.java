package com.codeyang.jrxtraining.CollectionStudy.CollectionDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 41765
 * @Creater 2020/5/14 18:33
 * Description
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // 创建一个空的双向链表对象linkedList
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println("新建的linkedList："+linkedList);
        //添加一个元素a
        boolean result = linkedList.add("a");
        System.out.println("添加元素a至链表末尾："+linkedList);
        //向头部插入一个元素b
        linkedList.addFirst("b");
        System.out.println("添加b元素至链表头部尾："+linkedList);
        //向指定位置插入一个元素c
        linkedList.add(1, "c");
        System.out.println("向索引1处添加c："+linkedList);

        //将指定集合中的所有元素添加到链表末尾
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        result = linkedList.addAll(list);
        System.out.println("将一个集合添加至链表末尾："+linkedList);
        //移除链表的第一个元素，并返回该元素
        String firstElement = linkedList.remove();
        System.out.println("移除链表的第一个元素，并返回该元素："+firstElement);
        //移除链表中指定位置处的元素，并返回该元素
        String specifiedIndexElement = linkedList.remove(3);
        System.out.println("移除链表中指定位置处的元素，并返回该元素："+specifiedIndexElement);
        //若元素存在则从链表中该元素第一次出现的位置移除该元素
        result = linkedList.remove("a");
        //判断链表中是否存在指定元素
        result = linkedList.contains("b");
        System.out.println("判断链表中是否存在'b'元素："+result);
        //返回链表中指定位置的元素
        String specifiedElement = linkedList.get(2);
        System.out.println("返回链表中位置2的元素："+result);
        //返回链表的最后一个元素
        String lastElement = linkedList.getLast();
        System.out.println("返回链表的最后一个元素："+lastElement);
        //返回指定元素在链表中第一次出现的位置，若未找到则返回-1
        int index = linkedList.indexOf("b");
        //将链表中指定位置处的元素修改为指定的元素，返回被替换的元素
        String element = linkedList.set(1, "a");
        //返回链表中包含的元素的数量
        int sizeOfLinkedList = linkedList.size();
        System.out.println("返回链表中包含的元素的数量："+sizeOfLinkedList);
        //以适当的顺序（从第一个元素到最后一个元素）返回包含此链表中所有元素的数组
        Object[] elements = linkedList.toArray();
//        System.out.println("将链表转为数组："+elements[1]);
    }
}
