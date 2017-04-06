package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root==null){
    		return res;
    	}
    	List<Integer> list = new ArrayList<Integer>();
    	this.help(root,0,sum,list,res);
    	return res;
    }
    private void help(TreeNode root,int current_sum, int sum, List<Integer> list,List<List<Integer>> res){
    	if(root==null){
    		return;
    	}
    	list.add(root.val);
    	current_sum += root.val;
    	boolean isLeaf = (root.left == null) && (root.right == null);
    	if(current_sum==sum && isLeaf){
    		res.add(new ArrayList<Integer>(list));
    	}
    	if(root.left!=null){
    		this.help(root.left, current_sum, sum, list, res);
    	}
    	if(root.right!=null){
    		this.help(root.right, current_sum, sum, list, res);
    	}
    	list.remove(list.size()-1);
    	
    }
}
