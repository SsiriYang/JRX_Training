package com.codeyang.jrxtraining.CollectionStudy.MapDemo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author 41765
 * @Creater 2020/5/14 18:32
 * Description
 */
public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Student2, String> tm = new TreeMap<Student2, String>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                // 主要条件
                int num = s1.getAge() - s2.getAge();
                // 次要条件
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        // 创建学生对象
        Student2 s1 = new Student2("潘安", 30);
        Student2 s2 = new Student2("柳下惠", 35);
        Student2 s3 = new Student2("唐伯虎", 33);
        Student2 s4 = new Student2("燕青", 32);
        Student2 s5 = new Student2("唐伯虎", 33);

        // 存储元素
        tm.put(s1, "宋朝");
        tm.put(s2, "元朝");
        tm.put(s3, "明朝");
        tm.put(s4, "清朝");
        tm.put(s5, "汉朝");

        // 遍历
        Set<Student2> set = tm.keySet();
        for (Student2 key : set) {
            String value = tm.get(key);
            System.out.println(key.getName() + "---" + key.getAge() + "---"
                    + value);
        }
    }
}

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
