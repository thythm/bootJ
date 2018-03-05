package com.momo.java.core.collectionJ;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.*;

/**
 * 集合相关知识点
 * @author majunjie
 * @date 2018/3/5 23:29
 */
public class CollectionCase {

    static CollectionCase instance = new CollectionCase();

    public static void main(String[] args) {
//        removeSame();
        comparable();
    }

    public static void removeSame() {

        List<Integer> oris = Arrays.asList(1,6,3,3,4,3,5,6);
        List<Integer> list = new ArrayList<>(6);
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);

        for (Integer value : oris) {
            Iterator<Integer> iterator = list.iterator();
            int count = 0;
            while (iterator.hasNext()) {
                if (value.equals(iterator.next())) {
                    count++;
                    if (count>1) {
                        System.out.println(value);
                        iterator.remove();
                    }
                }
            }
        }
    }

    public static void comparable() {

        List<Person> persons = new ArrayList<>(3);
        persons.add(instance.new Person("bbb", 10));
        persons.add(instance.new Person("ccc", 8));
        persons.add(instance.new Person("aaa", 8));

        persons.sort(Comparator.comparingInt(Person::getAge));
        System.out.println(JSONObject.toJSONString(persons));
        persons.sort((o1, o2) -> {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age < o2.age) {
                return -1;
            } else {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(JSONObject.toJSONString(persons));

    }

    @Data
    class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


}
