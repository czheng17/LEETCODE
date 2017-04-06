package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_77 {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(n==0){
    		return res;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	this.dfs_method(n,k,1,res,list);
    	return res;
    }
    private void dfs_method(int n, int k,int index,List<List<Integer>> res,List<Integer> list){
    	if(list.size()==k){
    		res.add(new ArrayList(list));
    		return;
    	}
    	for(int i=index;i<=n;i++){
    		if(list.size()<k ){
    			list.add(i);
    			this.dfs_method(n, k, i+1, res, list);
    			list.remove(list.size()-1);
    		}
    	}
    }
}
