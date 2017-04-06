package com.aslan.middle;

public class L_287 {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		int find = 0;
		while(find != slow){
			find = nums[find];
			slow = nums[slow];
		}
		return find;
	}
}
