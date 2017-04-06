package com.aslan.easy;

public class L_268 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0;i<nums.length;i++){
        	res = res ^ nums[i] ^ i;
        }
        return res;
    }
}
