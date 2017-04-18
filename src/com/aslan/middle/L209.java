package com.aslan.middle;

import java.util.Arrays;

/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * **/
public class L_209 {
	public int minSubArrayLen(int s, int[] nums) {  
        //init check  
        int start = 0;  
        int end = 0;  
          
        int sum = 0;  
        int min = Integer.MAX_VALUE;  
          
        while(start<nums.length && end<nums.length) {  
            while(sum<s && end<nums.length) {  
                sum += nums[end++];  
            }  
            while(sum>=s && start<=end) {  
                min = Math.min(min, end-start);  
                sum -= nums[start++];  
            }  
        }  
        return min==Integer.MAX_VALUE ? 0 : min;  
    }  
//	int res = Integer.MAX_VALUE;
//    public int minSubArrayLen(int s, int[] nums) {
//    	Arrays.sort(nums);
//        this.recur(0,0,0,s,nums);
//        return res;
//    }
//    private void recur(int index,int sum,int num,int s,int[] nums){
//    	if(sum==s){
//    		if(num<res){
//    			res = num;
//    		}
//    		return;
//    	}
//    	if(sum>s){
//    	    return;
//    	}
//    	for(int i=index;i<nums.length;i++){
//    		sum = sum + nums[index];
//    		num++;
//    		this.recur(index, sum, num, s, nums);
//    		num--;
//    		sum = sum-nums[index];
//    	}
//    }
}
