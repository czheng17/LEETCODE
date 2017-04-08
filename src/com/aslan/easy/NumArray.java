package com.aslan.easy;
/*
 * 303. Range Sum Query - Immutable
 * 
 * */
public class NumArray {
    int[] vals;
    public NumArray(int[] nums) {
        vals = new int[nums.length];
        if(vals.length == 0)
            return;

        vals[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            vals[i] = vals[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(vals.length == 0)
            return 0;

       if(j > vals.length-1)
            j = vals.length-1;

        if(i <= 0)
            return vals[j];
        return vals[j]-vals[i-1];
    }
}
