package com.aslan.middle;
/**
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], 
therefore the length is 4. Note that there may be more than one LIS combination, 
it is only necessary for you to return the length.

method 2:
这道题让我们求最长递增子串Longest Increasing Subsequence的长度，简称LIS的长度。我最早接触到这道题是在LintCode上，
可参见我之前的博客Longest Increasing Subsequence 最长递增子序列，那道题写的解法略微复杂，下面我们来看其他的一些解法。
首先来看一种动态规划Dynamic Programming的解法，这种解法的时间复杂度为O(n2)，类似brute force的解法，我们维护一个一维dp数组，
其中dp[i]表示以nums[i]为结尾的最长递增子串的长度，对于每一个nums[i]，我们从第一个数再搜索到i，如果发现某个数小于nums[i]，
我们更新dp[i]，更新方法为dp[i] = max(dp[i], dp[j] + 1)，
即比较当前dp[i]的值和那个小于num[i]的数的dp值加1的大小，我们就这样不断的更新dp数组，到最后dp数组中最大的值就是我们要返回的LIS的长度，
 * **/
import java.util.Arrays;

public class L_300 {
	
public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
// 	 public int lengthOfLIS(int[] nums) {
// 		 if(nums==null || nums.length==0){
// 			 return 0;
// 		 }
// 		 int[] dp = new int[nums.length];
// 		 Arrays.fill(dp, 1);
		 
// 		 for(int i=1;i<nums.length;i++){
// 			 for(int j=0;j<i;j++){
// 				 if(nums[j]<nums[i]){
// 					 if(dp[j]>=dp[i]){
// 						 dp[i] = dp[j]+1;
// 					 }
// 				 }
// 			 }
// 		 }
// 		 int max=0;
// 		 for(int i=0;i<dp.length;i++){
// 			 if(dp[i]>max){
// 				 max = dp[i];
// 			 }
// 		 }
// 		 return max;
// 	 }
	
}
