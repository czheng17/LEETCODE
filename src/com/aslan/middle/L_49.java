package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],  
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * 
 * */
public class L_49 {
	//方法1 快
	public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(strs==null){
    		return res;
    	}
    	Map<String,List<String>> map = new HashMap<String,List<String>>();
    	
    	for(int i=0;i<strs.length;i++){
    		String s = strs[i];
    		char[] tmp = strs[i].toCharArray();
    		Arrays.sort(tmp);
    		String union = String.valueOf(tmp);
    		List<String> save_string = new ArrayList<String>();
    		if(map.containsKey(union)){
    			save_string = map.get(union);
    		}
    		save_string.add(s);
    		map.put(union, save_string);
    	}
    	
    	for(List<String> list : map.values()){
    		Collections.sort(list);
    		res.add(list);
    	}
    	
    	return res;
	}
	
	
	//方法2 慢
//    public List<List<String>> groupAnagrams(String[] strs) {
//    	List<List<String>> res = new ArrayList<List<String>>();
//    	if(strs==null){
//    		return res;
//    	}
//    	
//    	Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
//    	
//    	for(int i=0; i<strs.length;i++){
//    		char[] tmp = strs[i].toCharArray();
//    		Arrays.sort(tmp);
//    		String union = Arrays.toString(tmp);
//    		List<Integer> save_index = new ArrayList<Integer>();
//    		if(map.containsKey(union)){
//    			save_index = map.get(union);
//    		}
//    		save_index.add(i);
//    		map.put(union, save_index);
//    	}
//
//    	for (String s : map.keySet()) {
//    		//System.out.println(s);
//    		List<Integer> indexs = map.get(s);
//    		List<String> group = new ArrayList<String>();
//    		for(int i=0;i<indexs.size();i++){
//    			group.add(strs[indexs.get(i)]);
//    		}
//    		
//    		// 按字典序排序
//            group.sort(new Comparator<String>() {
//                public int compare(String x, String y) {
//                    return x.compareTo(y);
//                }
//            });
//            
//    		res.add(group);
//    	}
//    	
//    	return res;
//    }
}
