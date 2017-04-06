package com.aslan.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.pop();
			list.addFirst(top.val);
			if(top.left != null){
				//root = top.left;
				stack.push(top.left);
			}
			if(top.right != null){
				//root = top.right;
				stack.push(top.right);
			}
			
		}
		return list;
        
    }
}
