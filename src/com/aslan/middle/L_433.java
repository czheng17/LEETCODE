package com.aslan.middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class L_433 {
    public int minMutation(String start, String end, String[] bank) {
        if(bank==null || bank.length==0){
        	return 0;
        }
        List<String> list = Arrays.asList(bank);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        if(list.contains(start)){
        	list.remove(start);
        }
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<list.size();i++){
        	map.put(list.get(i), 0);
        }
        map.put(start, 0);
        char[] four_element = {'A','C','G','T'};
        while(!queue.isEmpty()){
        	String pop = queue.poll();
        	int res = map.get(pop);
        	if(map.containsKey(start)){
        		map.remove(start);
        	}
        	for(int a=0;a<pop.length();a++){
            	StringBuilder sb = new StringBuilder(pop);
        		for(int c=0;c<four_element.length;c++){
            		sb.setCharAt(a, four_element[c]);
            		if(sb.toString().equals(end)){
            			return res+1;
            		}
            		if(map.containsKey(sb.toString())){
            			queue.offer(sb.toString());
            			map.put(sb.toString(), res+1);
            			list.remove(sb.toString());
            		}
            	}
        	}
        }
        return 0;
    }
}
