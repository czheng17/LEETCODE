package com.aslan.easy;

public class L_169 {
    public int majorityElement(int[] nums) {
        int m=nums[0];
        int c=1;
        for(int i=1;i<nums.length;i++){
        	if(m==nums[i]){
        		c++;
        	}else if(c>1){
        		c--;
        	}else{
        		m = nums[i];
        	}
        }
        return m;
    }
}
