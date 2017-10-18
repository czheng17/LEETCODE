package com.aslan.easy;
/*
 * Given an array consisting of n integers, find the contiguous subarray of given length k 
 * that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

soulution:利用slide window
开始 取【1，12，-5，-6】 sum = 2, max = 2;
然后做slide window:
       [12,-5,-6,50] tmp = 50-1=49, max = (2,2+49) = 51;
       [-5,-6,50,3]  tmp = 3-12=-9  max = (51,51-9) = 51s
 * 
 * */
public class L_643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int max = sum;
        
        for(int i=k;i<nums.length;i++){
            int tmp = nums[i] - nums[i-k];
            sum = sum + tmp;
            max = Math.max(max,sum);
        }
        return max/1.0/k;
    }
}
