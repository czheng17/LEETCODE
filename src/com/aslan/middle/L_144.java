package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class L_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || root != null){
			if(root != null){
				list.add(root.val);
				stack.push(root);
				root = root.left;
				
			}
			else if(root == null){
				TreeNode p = stack.pop();
				root = p.right;
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		L_144 sol = new L_144();
		TreeNode node = new TreeNode(1);
		List<Integer> result = sol.preorderTraversal(node);
		for(int i=0;i<result.size(); i++){
			System.out.println(result.get(i));
		}
		
	}
}

