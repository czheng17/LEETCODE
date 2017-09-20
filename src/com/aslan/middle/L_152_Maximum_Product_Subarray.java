package com.aslan.middle;


/*
 * 
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * [ 2 3 -2 4]
 * 
 *  		2	3	-2		4
 *a				6	-12		-8
 *
 *b				2	-4		-48
 *
 *tmpmax		6	-2		4
 *
 *tmpmin		2	-12		-48
 *
 *manpro		6	6		6
 * 
 * */

public class L_152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        if(nums.length==1){
        	return nums[0];
        }
        int tmpmax=nums[0];
        int tmpmin=nums[0];
        int maxProduct=nums[0];
        for(int i=1;i<nums.length;i++){
        	int a = tmpmax * nums[i];
        	int b = tmpmin * nums[i];
        	tmpmax = Math.max(Math.max(a, b), nums[i]);
        	tmpmin = Math.min(Math.min(a, b), nums[i]);
        	maxProduct = Math.max(tmpmax, maxProduct);
        }
        return maxProduct;
    }
}
