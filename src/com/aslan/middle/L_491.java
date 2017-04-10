package com.aslan.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 
 * **/
public class L_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
    	Set<List<Integer>> res = new HashSet<>();
    	if(nums==null || nums.length==0){
    		return new ArrayList<List<Integer>>();
    	}
    	List<Integer> list = new ArrayList<>();
    	int start=0;
    	this.recur(start,list,res,nums);
    	List final_res = new ArrayList(res);
    	return final_res;
    }
    private void recur(int start,List<Integer> list,Set<List<Integer>> res,int[] nums){
    	if(list.size()>=2){
    		res.add(new ArrayList(list));
    	}
    	for(int i=start;i<nums.length;i++){
    		if(list.size()==0 || list.get(list.size()-1)<=nums[i]){
        		list.add(nums[i]);
        		this.recur(i+1, list, res, nums);
        		list.remove(list.size()-1);
    		}
    	}
    }
    
}
