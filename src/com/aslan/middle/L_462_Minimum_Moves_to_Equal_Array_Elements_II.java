package com.aslan.middle;

import java.util.Arrays;
/*
 * Given a non-empty integer array, find the minimum number of moves 
 * required to make all array elements equal, where a move is incrementing a selected element 
 * by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * */
public class L_462_Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        int step=0;
        Arrays.sort(nums);
        int begin=0;
        int end = nums.length-1;
        while(begin<end){
        	step += nums[end--] - nums[begin++];
        }
        return step;
    }
}
