package com.aslan.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_506 {
    public String[] findRelativeRanks(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int i=0;i<nums.length;i++){
    		map.put(nums[i], i);
    	}
    	Arrays.sort(nums);
    	String[] res = new String[nums.length];
    	
    	for(int i=0;i<nums.length;i++){
    		int index = (int)map.get(nums[i]);
    		
    		if(i==nums.length-1){
    			res[index] = "Gold Medal";
    		}
    		else if(i==nums.length-2){
    			res[index] = "Silver Medal";
    		}
    		else if(i==nums.length-3){
    			res[index] = "Bronze Medal";
    		}
    		else{
    			res[index] = Integer.toString(nums.length - i);
    		}
    	}
    	return res;
    }
}
