package com.aslan.easy;

public class L_1 {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
		return result;
    }
	
	public static void main(String[] args) {
		L_1 sol = new L_1();
		int nums[] = {3,2,4};
		int target = 6;
		int [] result = new int[2];
		result = sol.twoSum(nums, target);
		System.out.println(result[0]+" "+result[1]);
	}
}


