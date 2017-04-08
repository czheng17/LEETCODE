package com.aslan.middle;

public class L_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] fwd = new int[nums.length];
        int[] bwd = new int[nums.length];
        fwd[0]=1;
        bwd[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++){
        	fwd[i] = fwd[i-1] * nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
        	bwd[i] = bwd[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
        	res[i] = fwd[i] * bwd[i];
        }
        return res;
    }
}
