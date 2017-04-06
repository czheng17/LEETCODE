package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_40 {
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		//List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<List<Integer>> res =new HashSet<List<Integer>>();
		if(candidates == null){
			return (new ArrayList<List<Integer>>(res));
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		int sum=target;
		this.dfs_method(0,sum,target,candidates,list,res);
		
		
		return (new ArrayList<List<Integer>>(res));
    }
	
	private void dfs_method(int index, int sum,int target, int[] candidates,List<Integer> list,Set<List<Integer>> res){
		if(sum==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=index;i<candidates.length;i++){
			if(sum+candidates[i]>=0){
				sum=sum-candidates[i];
				list.add(candidates[i]);
				this.dfs_method(i+1, sum, target, candidates, list, res);
				sum=sum+candidates[i];
				list.remove(list.size()-1);
			}
			else if(sum+candidates[i]<0){
				return;
			}
		}
	}
	
	
	
	
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		if(candidates == null){
//			return res;
//		}
//		List<Integer> list = new ArrayList<Integer>();
//		Arrays.sort(candidates);
//		int sum=target;
//		this.dfs_method(0,sum,target,candidates,list,res);
//		
//		List<List<Integer>> final_res = new ArrayList<List<Integer>>();
//		for(List<Integer> i: res){
//			if(!final_res.contains(i)){
//				final_res.add(i);
//			}
//		}
//		return final_res;
//    }
//	
//	private void dfs_method(int index, int sum,int target, int[] candidates,List<Integer> list,List<List<Integer>> res){
//		if(sum==0){
//			res.add(new ArrayList<Integer>(list));
//			return;
//		}
//		for(int i=index;i<candidates.length;i++){
//			if(sum+candidates[i]>=0){
//				sum=sum-candidates[i];
//				list.add(candidates[i]);
//				this.dfs_method(i+1, sum, target, candidates, list, res);
//				sum=sum+candidates[i];
//				list.remove(list.size()-1);
//			}
//			else if(sum+candidates[i]<0){
//				return;
//			}
//		}
//	}
}
