package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length==0){
        	return res;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxValue=0;
        for(int i=0;i<nums.length;i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        		if(1 > maxValue){
        			maxValue=1;
        		}
        	}else{
        		int tmp_value = map.get(nums[i])+1;
        		if(tmp_value > maxValue){
        			maxValue=tmp_value;
        		}
        		map.put(nums[i],tmp_value );
        	}
        }
        while(k >0){
        	boolean isok=false;
        	for(Integer a:map.keySet()){
        	    
        		if(map.get(a)==maxValue){
        			res.add(a);
        			map.remove(a);
        			k--;
        			isok=true;
        			break;
        		}
        	}
        	if(isok==false){
        		maxValue--;
        	}
        }
        return res;
    }
    

}
