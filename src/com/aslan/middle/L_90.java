package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0){
        	return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        this.helper(nums,list,res,0);
        return res;
    }
    private void helper(int[] nums,List<Integer> list,List<List<Integer>> res, int index){
    	res.add(new ArrayList<Integer>(list));
    	for(int i=index;i<nums.length;i++){
    		list.add(nums[i]);
    		this.helper(nums, list, res, i+1);
    		list.remove(list.size()-1);
    		
        	while(i+1<nums.length && nums[i+1]==nums[i]){
        		i++;
        	}
    	}

    }
}
