package com.aslan.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_205 {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null){
        	return false;
        }
        if(s.length() != t.length()){
        	return false;
        }
        //存放1对1映射的键值对
        Map<Character,Character> map = new HashMap<Character,Character>();
        //存放已经被配值过的t中的字母，若之后再出现，一定错了
        Set<Character> set = new HashSet<Character>();
        
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for(int i=0;i<s.length();i++){
        	
        	if(map.containsKey(s_char[i])){
        	    if(map.get(s_char[i])==t_char[i]){
        	        continue;
        	    }
        		if(map.get(s_char[i])!=t_char[i]){
        			return false;
        		}
        	}
        	else{
        	    if(set.contains(t_char[i])){
        			return false;
        		}
        	}
        	map.put(s_char[i], t_char[i]);
        	set.add(t_char[i]);
        }
        return true;
    }
}
