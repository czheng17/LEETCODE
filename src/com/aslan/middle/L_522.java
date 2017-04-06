package com.aslan.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_522 {
	public int findLUSlength(String[] strs) {
	      int res=0;
	      if(strs.length==0){
	      	return 0;
	      }
	      Arrays.sort (strs, new Comparator<String> ()
	      {
	          @Override
	          public int compare ( String o1, String o2 )
	          {
	              if (o1.length () > o2.length ())
	              {
	                  return 1;
	              }
	              else if (o1.length () < o2.length ())
	              {
	                  return -1;
	              }
	              else
	              {
	                  return 0;
	              }
	          }
	      });
	      for(int i=strs.length-2;i>=0;i--){
	    	  int cur_res=0;
	    	  for(int j=0;j<strs[i].length();j++){
	    		  if(strs[strs.length-1].charAt(j) != strs[i].charAt(j)){
	    			  cur_res++;
	    		  }
	    	  }
	    	  if(cur_res>res){
	    		  res=cur_res;
	    	  }
	      }
	      if(res==0){
	    	  return -1;
	      }
	      return res;
	}
//	public int findLUSlength(String[] strs) {
//        int res=0;
//        if(strs.length==0){
//        	return 0;
//        }
//        Arrays.sort (strs, new Comparator<String> ()
//        {
//            @Override
//            public int compare ( String o1, String o2 )
//            {
//                if (o1.length () > o2.length ())
//                {
//                    return 1;
//                }
//                else if (o1.length () < o2.length ())
//                {
//                    return -1;
//                }
//                else
//                {
//                    return 0;
//                }
//            }
//        });
//        for(int i=strs.length-2;i>=0;i--){
//        	Map<Character,Character> map =new HashMap<>();
//        	Set<Character> set = new HashSet<>();
//        	int cur_res=0;
//        	for(int j=0;j<strs[i].length();j++){
//        		if(!map.containsKey(strs[i].charAt(j)) ){
//        			if(set.contains(strs[strs.length-1].charAt(j))){
//        				break;
//        			}
//        			else{
//        				map.put(strs[i].charAt(j), strs[strs.length-1].charAt(j));
//        				set.add(strs[strs.length-1].charAt(j));
//        				cur_res++;
//        			}
//        		}
//        		else{
//        			if(j>=strs[strs.length-1].length()){
//        			    cur_res++;
//        				break;
//        			}
//        			if(map.get(strs[i].charAt(j))==strs[strs.length-1].charAt(j) ){
//        				cur_res++;
//        			}
//        			else{
//        				break;
//        			}
//        		}
//        	}
//        	if(cur_res>res){
//        		res = cur_res;
//        	}
//        }
//        return res;
//    }

}
