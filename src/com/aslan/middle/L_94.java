package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || root != null){
			if(root !=null){
				stack.push(root);
				root = root.left;
				
			}
			else if(root == null){
			    TreeNode top = stack.pop();
				list.add(top.val);
                root = top.right;
			}
		}
		return list;
	        
    }
}
