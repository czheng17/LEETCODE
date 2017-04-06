package com.aslan.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_290 {
	public boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null){
        	return false;
        }
        if(pattern.length()==0){
        	return false;
        }
        char[] c = pattern.toCharArray();
        String[] s = str.split(" ");
        if(c.length != s.length){
        	return false;
        }
        Map<Character,String> map = new HashMap<Character,String>();
        Set<String> set = new HashSet<String>();
        for(int i=0;i<pattern.length();i++){
        	if(map.containsKey(c[i])){
        		if(!map.get(c[i]).equals(s[i])){
        			return false;
        		}
        	}
        	else{
        		if(set.contains(s[i])){
        			return false;
        		}
        		map.put(c[i], s[i]);
        		set.add(s[i]);
        	}
        	
        }
        return true;
    }
}
