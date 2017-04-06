package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(n<1){
    		return res;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	int sum=n;
    	this.dfs_method(n,k,1,sum,res,list);
    	return res;
    }

    private void dfs_method(int n,int k,int index,int sum,List<List<Integer>> res,List<Integer> list){
    	if(list.size()==k && sum==0){
    		res.add(new ArrayList<Integer>(list));
    	}
    	
    	for(int i=index;i<=9;i++){
    		if(list.size()<k){
    			sum=sum-i;
    			list.add(i);
        		this.dfs_method(n, k, i+1, sum, res, list);
        		sum=sum+i;
        		list.remove(list.size()-1);
    		}
    	}
    }
}
