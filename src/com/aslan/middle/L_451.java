package com.aslan.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class L_451 {
	//超时
//    public String frequencySort(String s) {
//        if(s==null || s.length()==0){
//        	return s;
//        }
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        for(int i=0;i<s.length();i++){
//        	char tmp = s.charAt(i);
//        	map.put(tmp, map.getOrDefault(tmp, 0)+1);
//        }
//        List<Character>[] list = new List[s.length()+1];
//
//        for(Map.Entry<Character, Integer> entry: map.entrySet()){
//        	if(list[entry.getValue()]==null){
//        		list[entry.getValue()] = new ArrayList<>();
//        	}
//        	list[entry.getValue()].add(entry.getKey());
//        }
//
//        String res="";
//        for(int i=s.length();i>=0;i--){
//        	if(list[i]!=null){
//        		for(int j=0;j<list[i].size();j++){
//        			for(int k=0;k<i;k++){
//        				res+=list[i].get(j);
//        			}
//        		}
//        	}
//        }
//        return res;
//    }
	
	//通过
    public String frequencySort(String s) {
        if(s==null || s.length()==0){
        	return s;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
        	char tmp = s.charAt(i);
        	map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
