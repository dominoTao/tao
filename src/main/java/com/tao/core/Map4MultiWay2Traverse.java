package com.tao.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map4MultiWay2Traverse {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
		//traverse	迭代器 EntrySet
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
        	Map.Entry<Integer,String> entry = iterator.next();
//        	System.out.print(entry.getKey()+"\t");
//        	System.out.println(entry.getValue());
        }
        //traverse	迭代器 KeySet
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while(iterator2.hasNext()) {
        	Integer key = iterator2.next();
//        	System.out.print(key+"\t");
//        	System.out.println(map.get(key));
        }
        //traverse	ForEach EntrySet
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
//        	System.out.print(entry.getKey()+"\t");
//        	System.out.println(entry.getValue());
        }
        //traverse	ForEach KeySet
        for(Integer key : map.keySet()) {
//        	System.out.print(key+"\t");
//        	System.out.println(map.get(key));
        }
        //traverse	lambda
        map.forEach((key, value) -> {
//        	System.out.print(key+"\t");
//        	System.out.println(value);
        });
        //traverse	Stream API 单线程
        map.entrySet().stream().forEach((entry) -> {
//        	System.out.print(entry.getKey()+"\t");
//        	System.out.println(entry.getValue());
        });
        //traverse	Stream API 多线程
        map.entrySet().parallelStream().forEach((entry) -> {
        	System.out.print(entry.getKey()+"\t");
        	System.out.println(entry.getValue());
        });
	}
}

