package com.aslan.middle;

import java.util.Arrays;

public class L_215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        Arrays.sort(nums);
        int res_index = nums.length - k;
        return nums[res_index];
    }
}
