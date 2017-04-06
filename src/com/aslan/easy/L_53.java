package com.aslan.easy;

public class L_53 {
	public int maxSubArray(int[] nums) {
        //制表 这道题一个一维数组足矣
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];
        //状态转移方程
        for(int i = 0;i<nums.length; i++){
        	sum[i] = Math.max(nums[i], nums[i]+sum[i-1]);
        	max = Math.max(max, sum[i]);
        }
        return max;
    }
}
