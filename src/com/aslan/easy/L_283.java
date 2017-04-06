package com.aslan.easy;

public class L_283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int size = nums.length;
        while(i<size && j<size){
        	while(i<size && nums[i]!=0){
        		i++;
        	}
        	while(j<size && (nums[j]==0 || j<i)){
        		j++;
        	}
        	if(i<size && j<size){
            	nums[i] = nums[j];
            	nums[j] = 0;
            	i++;
            	j++;
        	}
        }
    }
}
