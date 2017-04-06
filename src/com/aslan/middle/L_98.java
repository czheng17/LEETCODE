package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_98 {
	  public boolean isValidBST(TreeNode root) {
	  if(root==null){
	  	return true;
	  }
	  Stack<TreeNode> stack = new Stack<TreeNode>();
	  
//	  int previous_val = Integer.MIN_VALUE;
	  List<Integer> list = new ArrayList<Integer>();
	  while(!stack.isEmpty() || root!=null){
	  	if(root != null){
	  		stack.push(root);
	  		root = root.left;
	  	}
	  	if(root==null){
	  		TreeNode top = stack.pop();
	  		list.add(top.val);
//	  		int current_val = top.val;
//	  		if(current_val<previous_val){
//	  			return false;
//	  		}
	  		root = top.right;
	  	}
	  }
	  for(int i=1;i<list.size();i++){
		  if(list.get(i)<=list.get(i-1)){
			  return false;
		  }
	  }
	  return true;
	}
	
	
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//        	return true;
//        }
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        
//        long previous_val = Long.MIN_VALUE;
//        while(!stack.isEmpty() || root!=null){
//        	if(root != null){
//        		stack.push(root);
//        		root = root.left;
//        	}
//        	if(root==null){
//        		TreeNode top = stack.pop();
//        		long current_val = top.val;
//        		if(current_val<=previous_val){
//        			return false;
//        		}
//        		root = top.right;
//        	}
//        }
//        return true;
//    }
}
