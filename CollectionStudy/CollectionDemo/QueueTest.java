package com.codeyang.jrxtraining.CollectionStudy.CollectionDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 41765
 * @Creater 2020/5/14 21:18
 * Description
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add("aaa");
        queue.add("bbb");
        //获取队首元素，若成功，则返回队首元素；否则返回null
        System.out.println(queue.peek());
        //移除并获取队首元素，若成功，则返回队首元素；否则返回null；
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //移除队首元素，若移除成功，则返回true；如果移除失败（队列为空），则会抛出异常；
        System.out.println(queue.remove());
    }
}
