package com.aslan.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length()<p.length()){
        	return res;
        }
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<p.length();i++){
        	set.add(p.charAt(i));
        }

        for(int index=0;index<=s.length()-p.length();index++){
        	String tmp = s.substring(index, index+p.length());
        	char op_xor = '0';
        	boolean is_true=true;
        	for(int i=0;i<tmp.length();i++){
        		if(!set.contains(tmp.charAt(i))){
        			is_true=false;
        			break;
        		}
        		op_xor ^= p.charAt(i);
        		op_xor ^= tmp.charAt(i);

        	}
    		if(is_true==true && op_xor=='0'  ){
    			res.add(index);
    		}
        }
        return res;
    }
}
