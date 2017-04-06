package com.aslan.easy;

public class L_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==1){
        		count++;
        	}
        	else{
        		count=0;
        	}
        	res = Math.max(count, res);
        }
        return res;
    }
}
