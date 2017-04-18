package com.aslan.middle;
/**
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], 
therefore the length is 4. Note that there may be more than one LIS combination, 
it is only necessary for you to return the length.
 * **/
import java.util.Arrays;

public class L_300 {
	 public int lengthOfLIS(int[] nums) {
		 if(nums==null || nums.length==0){
			 return 0;
		 }
		 int[] dp = new int[nums.length];
		 Arrays.fill(dp, 1);
		 
		 for(int i=1;i<nums.length;i++){
			 for(int j=0;j<i;j++){
				 if(nums[j]<nums[i]){
					 if(dp[j]>=dp[i]){
						 dp[i] = dp[j]+1;
					 }
				 }
			 }
		 }
		 int max=0;
		 for(int i=0;i<dp.length;i++){
			 if(dp[i]>max){
				 max = dp[i];
			 }
		 }
		 return max;
	 }
}
