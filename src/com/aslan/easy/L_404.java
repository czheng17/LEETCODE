package com.aslan.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_404 {
//    public int sumOfLeftLeaves(TreeNode root) {
//		if(root==null){
//			return 0;
//		}
//		int sum = 0;
//		Queue<TreeNode> queue = new LinkedList<TreeNode>();
//		queue.offer(root);
//		while(!queue.isEmpty()){
//			TreeNode top = queue.poll();
//			//System.out.println(top.val);
//			if(top.left!=null){
//				if(top.left.left==null && top.left.right==null){
//					sum += top.left.val;
//				}
//				queue.offer(top.left);
//			}
//			if(top.right!=null){
//				queue.offer(top.right);
//			}
//		}
//		return sum;
//	}
	
	public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
		int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode pop = stack.pop();
        	if(pop.left!=null){
            	if(pop.left.left==null&& pop.left.right==null){
            		sum += pop.left.val;
            	}
        		stack.push(pop.left);
        	}

        	if(pop.right!=null){
        		stack.push(pop.right);
        	}
        }
        return sum;
    }
}
