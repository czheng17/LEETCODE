package com.aslan.middle;

import java.util.Arrays;
import java.util.Comparator;

/*
 * You are given n pairs of numbers. In every pair, 
 * the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) 
if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. 
You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

如果想使用Greedy来解决这个问题，那么只能是按照数组的第二个元素排序。(按照数组的第一个元素排序将会行不通）。
如 (8,9) (10,11) (1,100)。
按照数组第一个元素排序： (1,100)，(8,9)， (10,11) 。不能通过比较 [i][end] 和 [i+1][begin] 来增加链。
而如果按照数组第二个元素排序： (8,9) ，(10,11)， (1,100)，那么则可以通过比较 [i][end] 和 [i+1][begin] 来增加链。
 * 
 * */
public class L_646_Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
    	int sum=0;
    	int cur_end = Integer.MIN_VALUE;
        Arrays.sort(pairs,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});
        for(int[] pair : pairs){
        	if(pair[0]>cur_end){
        		sum++;
        		cur_end = pair[1];
        	}
        }
        return sum;
    }
}
