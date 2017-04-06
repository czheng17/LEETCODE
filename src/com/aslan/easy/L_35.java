package com.aslan.easy;

public class L_35 {
	public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        if(target<=nums[0]){
            return 0;
        }
        int index=1;
        for(int i=0;i<nums.length;i++){
            if(index==nums.length){
                return index;
            }
        	if(nums[i]<=target && nums[index]>=target){
        		return index;
        	}
        	index++;
        }
        return 0;
    }
	
}
