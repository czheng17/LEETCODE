package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<4){
        	return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	//若nums[i]!=nums[i-1]，直接i++  [1,2,2,3,4] 见到nums[2]==nums[1],i++
        	if(i==0 || ( i>0 && nums[i]!=nums[i-1] ) ){
        		for(int j=i+1;j<nums.length;j++){
        			//若nums[j]!=nums[j-1]，直接i++下一循环  [0,1,2,2,3,4] 见到nums[2]==nums[1],j++下一循环
        			if(j==i+1 || ( j>i+1 && nums[j]!=nums[j-1] ) ){
        				int tmp = target - nums[i] - nums[j];
        				int left = j+1;
        				int right = nums.length-1;
        				while(left<right){
        					if(nums[left]+nums[right]==tmp){
        						res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
        						
        						int leftValue = nums[left];
        						int rightValue = nums[right];
        						while(left<nums.length && nums[left]==leftValue){
        							left++;
        						}
        						while(right>j && nums[right]==rightValue){
        							right--;
        						}
        					}
        					else if(nums[left]+nums[right]<tmp){
        						left++;
        					}
        					else{
        						right--;
        					}
        				}
        			}
        		}
        	}
        }
        
        return res;
    }
}
