/**
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
首先subarray要连续，这题就跟之前range sum差不多。 
需要用map记录当前位置之前的和。


**/


public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<Integer, Integer>();
        if(nums == null || nums.length == 0) return 0;
        int len = 0, sum = 0;
        for(int i = 0; i<nums.length; ++i){
            sum += nums[i];
            if(sum == k) len = i+1;
            if(mp.containsKey(sum-k)){
                len = Math.max(len, i- mp.get(sum-k));
            }
            if(mp.containsKey(sum)) mp.put(sum, mp.get(sum));// if there already have sum, we should keep its idx, for longest array reason: [1,0,-1] k = -1, return 2;
            else mp.put(sum, i);
        }
        return len;
    }
}
