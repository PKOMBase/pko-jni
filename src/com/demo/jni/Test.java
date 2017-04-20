package com.demo.jni;

public class Test {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map2 = new MyHashMap<String, Integer>();
        map2.put("aaa", 1);
        map2.put("bbb", 2);
        map2.put("ccc", 3);
        map2.put("aaa", 4);
        map2.put(null, 5);
        System.out.println(map2.toString());
    }
}
