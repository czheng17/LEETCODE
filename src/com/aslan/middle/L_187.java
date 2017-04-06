package com.aslan.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s==null || s.length()<10){
        	return (new ArrayList<>());
        }
        Set<String> appear = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        //char[] s_char = s.toCharArray();
        for(int i=9;i<s.length();i++){
        	if(!appear.contains(s.substring(i-9,i+1))){
        		appear.add(s.substring(i-9,i+1));
        	}
        	else{
        		res.add(s.substring(i-9,i+1));
        	}
        }
        return (new ArrayList<String>(res));
    }
}
