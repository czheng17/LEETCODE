package com.aslan.middle;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
 * */
public class L_153 {
    public int findMin(int[] nums) {
        if(nums.length==1){
        	return nums[0];
        }
        if(nums.length==2){
        	return Math.min(nums[0], nums[1]);
        }
        
        int start=0;
        int end = nums.length -1;
        int middle = (start+end) /2;
        if(nums[start]<nums[end]){
        	return nums[start];
        }
        if(nums[middle]>nums[end]){
        	return findMin(Arrays.copyOfRange(nums, middle+1, end+1));
        }
        else{
        	return findMin(Arrays.copyOfRange(nums, start, middle+1));
        }
    }
}
