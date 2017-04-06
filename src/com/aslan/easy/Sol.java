package com.aslan.easy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;



public class Sol {
	public int solution(TreeNode root){
		Set<Integer> set  = new HashSet<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		
		while(root!= null){
			int root_val = root.val;
			int minus_val;
			while(!stack.isEmpty() || root != null){
				if(root != null){
					minus_val = root_val - root.val;
					if(set.contains(minus_val)){
						set.add(minus_val);
					}
					stack.push(root);
					root = root.left;
					
				}
				else if(root == null){
					TreeNode p = stack.pop();
					root = p.right;
				}
			}
			root_val = root.left.val;
		}
		int min=Integer.MAX_VALUE ;
		for(int i=0;i<set.size();i++){
			if(set.get(i)<min){
				set.
				min = set.get(i);
			}
		}
		return min;
		
		
		
		
	}
}
