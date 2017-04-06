package com.aslan.middle;

import java.util.List;

public class L_524 {
    public String findLongestWord(String s, List<String> d) {
        if(s==null || s.length()==0 || d.size()==0){
        	return "";
        }
        String res = "";
        for(int index=0;index<d.size();index++){
        	int i=0;
        	int j=0;
        	for(i=0;j<d.get(index).length() && i<s.length();i++){
        		if(s.charAt(i)==d.get(index).charAt(j)){
        			j++;
        		}
        	}
        	if(j == d.get(index).length() && ( (res.length() < d.get(index).length()) || (res.length() == d.get(index).length() && res.charAt(0)>d.get(index).charAt(0) ) )){
        		res = d.get(index);
        	}
        }
        return res;
    }
}
