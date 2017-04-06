package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;

public class L_242 {
    public boolean isAnagram(String s, String t) {
        if(s==null || t == null){
        	return false;
        }
        if(s.length() != t.length()){
        	return false;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for(int i =0;i<s.length();i++){
        	if(map.containsKey(s_char[i])){
        		map.put(s_char[i], map.get(s_char[i])+1);
        	}else{
        		map.put(s_char[i], 1);
        	}
        }
        for(int i =0;i<t.length();i++){
        	if(map.containsKey(t_char[i])){
        		map.put(t_char[i], map.get(t_char[i])-1);
        	}else{
        		return false;
        	}
        }
        
        for(char c: map.keySet()){
        	if(map.get(c)!=0){
        		return false;
        	}
        }
        return true;
    }
}
