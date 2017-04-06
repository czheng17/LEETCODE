package com.aslan.easy;

import java.util.HashSet;
import java.util.Set;

public class L_409 {
    public int longestPalindrome(String s) {
        if(s==null && s.length()==0){
        	return 0;
        }
        int res=0;
        char[] s_char = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
        	if(set.contains(s_char[i])){
        		res+=2;
        		set.remove(s_char[i]);
        	}
        	else{
        		set.add(s_char[i]);
        	}
        }
        if(!set.isEmpty()){
        	res++;
        }
        return res;
    }
}
