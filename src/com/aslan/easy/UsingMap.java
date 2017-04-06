package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;

public class UsingMap {
	public static void main(String[] args) {
		Map<String, String> map =new HashMap<String,String>();
		map.put("a", "b");
		map.put("b", "c");
		map.put("c", "d");
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+"   "+entry.getValue());
		}
		
		
		
	}
}
