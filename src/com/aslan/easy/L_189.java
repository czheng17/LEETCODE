package com.aslan.easy;

import java.lang.reflect.Array;

public class L_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] new_nums = new int[nums.length];
        int begin =nums.length - k;
        for(int i=0;i<k;i++){
        	new_nums[i] = nums[begin++];
        }
        begin=0;
        for(int i=k;i<new_nums.length;i++){
        	new_nums[i] = nums[begin++];
        }
        for(int i=0;i<nums.length;i++){
        	nums[i] = new_nums[i];
        }
    }
}
