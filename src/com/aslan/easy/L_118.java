package com.aslan.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * Total Accepted: 123964
Total Submissions: 329720
Difficulty: Easy
Contributor: LeetCode
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * 
 * 
 * **/
public class L_118 {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(numRows<1){
    		return res;
    	}
    	for(int i=0;i<numRows;i++){
    		List<Integer> list = new ArrayList<>();
    		for(int j=0;j<i+1;j++){
    			if(j==0 || j==i){
    				list.add(1);
    			}
    			else{
    				int top_left = res.get(i-1).get(j-1);
    				int top_right = res.get(i-1).get(j);
    				list.add(top_left+top_right);
    			}
    		}
    		res.add(list);
    	}
    	return res;
    }
}
