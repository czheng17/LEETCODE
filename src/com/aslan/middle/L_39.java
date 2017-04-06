package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 because 7 = 7
         2+2+3 = 7
         DFS
 * */
public class L_39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
List<List<Integer>> res = new ArrayList<List<Integer>>();
if(candidates.length == 0){
	return res;
}
List<Integer> list = new ArrayList<Integer>();
int sum=0;
int start_pos = 0;
Arrays.sort(candidates);
this.dfs_method(0,sum,list,res,candidates,target);
return res;
}

private void dfs_method(int start_pos,int sum,List<Integer> list,List<List<Integer>> res,int[] candidates, int target){
if(sum==target){
	res.add(new ArrayList<Integer>(list));
	return;
}
else{
	for(int i = start_pos; i< candidates.length;i++){
		if(sum+candidates[i]>target){
			return;
		}
		sum+=candidates[i];
		list.add(candidates[i]);
		this.dfs_method(i,sum, list, res, candidates, target);
		list.remove(list.size()-1);
		sum-=candidates[i];
	}
}
}
}
