package com.aslan.middle;

import java.util.Arrays;

public class L_334 {
	public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<3){
        	return false;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i=1;i<nums.length;i++){
        	for(int j=0;j<i;j++){
        		if(nums[j]<nums[i]){
        			if(dp[j]>=dp[i]){
        				dp[i]=dp[i]+1;
        				if(dp[i]==3){
        					return true;
        				}
        			}
        		}
        	}
        }
        return false;
    }
}
