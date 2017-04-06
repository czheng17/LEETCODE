package com.aslan.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_199 {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
        	return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	int each_layer_size = queue.size();
        	for(int i=0;i<each_layer_size;i++){
        		TreeNode top = queue.poll();
        		if(i==each_layer_size-1){
        			res.add(top.val);
        		}
        		if(top.left!=null){
        			queue.offer(top.left);
        		}
        		if(top.right!=null){
        			queue.offer(top.right);
        		}
        		
        	}
        	
        }
        return res;
    }
}
