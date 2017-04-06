package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

	For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * */
public class L_228 {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<>();
        if(nums==null || nums.length<1){
        	return res;
        }
        if(nums.length==1){
            res.add(nums[0]+"");
            return res;
        }
        int begin=0;
        int end=0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]-nums[i-1]==1){
        		end++;
        		if(i==nums.length-1){
        			res.add(nums[begin]+"->"+nums[end]);
        		}
        	}
        	else{
        		if(begin==end){
        			res.add(nums[end]+"");
        		}
        		else{
        			res.add(nums[begin]+"->"+nums[end]);
        		}
        		begin = i;
        		end = i;
        		if(i==nums.length-1){
        			res.add(nums[end]+"");
        		}
        	}
        }
        return res;
    }
}
