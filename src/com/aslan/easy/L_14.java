package com.aslan.easy;

public class L_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
        	return "";
        }
        String res="";
//        for(int i=0;i<strs.length;i++){
//        	char tmp = strs[i]
//        	for(int j=0;j<strs[0].length();j++){
//        		
//        	}
//        }
    	for(int i=0;i<strs[0].length();i++){
    		char tmp = strs[0].charAt(i);
    		for(int j=0;j<strs.length;j++){
    			if(tmp!=strs[j].charAt(i)){
    				return res;
    			}
    			if(i==strs[j].length()){
    				return res;
    			}
    		}
    		res += String.valueOf(strs[0].charAt(i));
    	}
        return res;
    }
}
