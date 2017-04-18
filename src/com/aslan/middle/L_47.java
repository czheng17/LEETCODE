package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums==null || nums.length==0){
			return res;
		}
		
		boolean[] visited = new boolean[nums.length];
		
		Arrays.sort(nums);
		this.recur(visited,list,nums,res);
		return res;
	}
	
	private void recur( boolean[] visited, List<Integer> list, int[] nums, List<List<Integer>> res){
		if(list.size()==nums.length){
			res.add(new ArrayList(list));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(i>0 && nums[i-1] == nums[i] && !visited[i-1]){
                continue;
			}
			if( visited[i]==false){
				list.add(nums[i]);
				visited[i]=true;
				this.recur( visited, list, nums, res);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
		
	}
}
