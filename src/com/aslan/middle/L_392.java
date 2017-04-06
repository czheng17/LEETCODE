package com.aslan.middle;

import java.util.HashMap;
import java.util.Map;

public class L_392 {
	public boolean isSubsequence(String s, String t) {
		   //   if(s==null){ return true; }
		   //   if(t==null){ return false;}
		      char[] s_char = s.toCharArray();
		      char[] t_char = t.toCharArray();
		      int point_s=0;
		      int s_index=0;
		      
		      for(int i=0;i<t.length();i++){
		    	  if(point_s==s.length()){
		    		  return true;
		    	  }
		    	  if(s_char[s_index]==t_char[i]){
		    		  point_s++;
		    		  s_index++;
		    	  }
		      }
		      return point_s == s.length();     
		}   
	
//	public boolean isSubsequence(String s, String t) {
//        if(s==null){ return true; }
//        if(t==null){ return false;}
//        char[] s_char = s.toCharArray();
//        char[] t_char = t.toCharArray();
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0;i<t_char.length;i++){
//        	map.put(t_char[i], map.getOrDefault(t_char[i], 0)+1);
//        }
//        for(int i=0;i<map.size();i++){
//        	if(map.containsKey(s_char[i])){
//        		map.put(s_char[i],map.get(s_char[i])-1);
//        		if(map.get(s_char[i])<0){
//        			return false;
//        		}
//        	}
//        	else{
//        		return false;
//        	}
//        }
//        return true;
//    }
}
