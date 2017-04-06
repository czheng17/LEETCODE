package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

/*
 * eg [1,2,3]
 * result: [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
 * my recursion:
1
12
123
13
132
2
21
213
23
231
3
31
312
32
321
 * 
 * */


public class L_46 {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0 || nums == null){
			return res;
		}
		List<Integer> list = new ArrayList<Integer>();
		this.helper(nums,list,res);
		return res;
	}
	private void helper(int[] nums,List<Integer> list,List<List<Integer>> res ){
		if(list.size()==nums.length){
			res.add(list);
			return;
		}
		else{
			for(int i = 0 ; i < nums.length ; i++){
				if(list.contains(nums[i])){
					continue;
				}
				list.add(nums[i]);
				this.helper(nums, list, res);
				list.remove(list.size()-1);
			}
		}
	}
//	public List<List<Integer>> permute(int[] nums){
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		List<Integer> list = new ArrayList<Integer>();
//		if(nums ==null || nums.length==0){
//			return res;
//		}
//		this.helper(nums,list,res);
//		return res;
//	}
//	private void helper(int[] nums, List<Integer> list,List<List<Integer>> res){
//		if(nums.length == list.size()){
//			res.add(new ArrayList<Integer>(list));
//			return;
//		}
//		for(int i = 0;i< nums.length; i++){
//			if(list.contains(nums[i])){
//				continue;
//			}
//			list.add(nums[i]);
//			for(int j = 0; j<list.size();j++){
//				System.out.print(list.get(j));
//			}
//			System.out.println();
//			this.helper(nums, list, res);
//			list.remove(list.size()-1);
//		}
//	}
	
}
