package com.codeyang.jrxtraining.CollectionStudy.CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author 41765
 * @Creater 2020/5/14 18:32
 * Description
 * 底层默认初始化10个长度的数组，如果插入的数据超过10，
 * 会创建一个新的数组，该数组是原来数组的1.5倍，并且把原来的数组赋值到新数组中。
 *
 */
public class ArrayListTest {
    public static void main(String[] args) {
            // 创建一个空的数组链表对象list，list用来存放String类型的数据
            ArrayList<String> list = new ArrayList<String>();
            // 增加元素到list对象中
            list.add("One");
            list.add("Two");
            list.add(2, "Three"); // 此条语句将会把“Item3”字符串增加到list的第3个位置。
            list.add("Four");

            // 显示数组链表中的内容
            System.out.println("数组链表中的内容是: "
                    + list);

            // 检索元素的位置
            int pos = list.indexOf("Two");
            System.out.println(" Two 再数组链表中的位置: " + pos);

            // 检查数组链表是否为空
            boolean check = list.isEmpty();
            System.out.println("检查数组链表是否为空: " + check);

            // 获取链表的大小
            int size = list.size();
            System.out.println("链表的大小: " + size);

            // 检查数组链表中是否包含某元素
            boolean element = list.contains("Five");
            System.out
                    .println("数组链表中是否包含'Five'元素: "
                            + element);

            // 获取指定位置上的元素
            String item = list.get(0);
            System.out.println("数组链表中索引为零元素: " + item);

            // 遍历arraylist中的元素

            // 第1种方法: 循环使用元素的索引和链表的大小
            System.out.println("循环使用元素的索引和链表的大小");
            for (int i = 0; i < list.size(); i++) {
                    System.out.println("Index: " + i + " - Item: " + list.get(i));
            }

            // 第2种方法:使用foreach循环
            System.out.println("使用foreach循环");
            for (String str : list) {
                System.out.println("Item is: " + str);
            }

            // 第三种方法:使用迭代器
            // hasNext(): 返回true表示链表链表中还有元素
            // next(): 返回下一个元素
            System.out.println("使用迭代器遍历:");
            for (Iterator<String> it = list.iterator(); it.hasNext();) {
                System.out.println("Item is: " + it.next());
            }

            // 替换元素
            list.set(1, "NewOne");
            System.out.println("替换过后的数组链表是 " + list);

            // 移除元素
            // 移除第0个位置上的元素
            list.remove(0);

            // 移除第一次找到的 "Item3"元素
            list.remove("Three");

            System.out.println("The final contents of the arraylist are: " + list);

            // 转换 ArrayList 为 Array
            String[] simpleArray = list.toArray(new String[list.size()]);
            System.out.println("arraylist的最终内容是: "
                    + Arrays.toString(simpleArray));
        }

}
