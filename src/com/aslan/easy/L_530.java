package com.aslan.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_530 {
	public int getMinimumDifference(TreeNode root) {
        int res=Integer.MAX_VALUE;
        //in-order 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int prior_node = 0;
        boolean is_first=true;
        while(root!=null || !stack.isEmpty() ){
        	if(root != null){
        		stack.push(root);
        		root = root.left;
        	}
        	else{
        		if(is_first==true){
        			TreeNode pop = stack.pop();
        			root=pop.right;
        			prior_node = pop.val;
        			is_first=false;
        			continue;
        		}
        		TreeNode pop = stack.pop();
        		if(pop.val-prior_node <res){
        			res = pop.val-prior_node;
        		}
        		prior_node = pop.val;
        		root=pop.right;
        	}
        }
        return res;
    }
}
