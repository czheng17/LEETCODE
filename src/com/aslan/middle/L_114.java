package com.aslan.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L_114 {

	public void flatten(TreeNode root) {
		Stack<TreeNode> stack =new Stack<>();
		TreeNode p = root;
		
		while(p!=null || !stack.isEmpty()){
			
			if(p.right!=null){
				stack.push(p.right);
			}
			
			if(p.left!=null){
				p.right = p.left;
				p.left=null;
			}
			else if(!stack.isEmpty()){
				TreeNode tmp = stack.pop();
				p.right = tmp;
			}
			p=p.right;
		}
	}
}
