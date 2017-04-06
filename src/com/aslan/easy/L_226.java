package com.aslan.easy;

import java.util.LinkedList;
import java.util.Queue;

public class L_226 {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null){
        	queue.offer(root);
        }
        while(!queue.isEmpty()){
        	TreeNode cur = queue.poll();
        	TreeNode tmp = cur.left;
        	cur.left = cur.right;
        	cur.right = tmp;
        	if(cur.left!=null){
        		queue.offer(cur.left);
        	}
        	if(cur.right!=null){
        		queue.offer(cur.right);
        	}
        	
        }
        return root;
    }
}
