package com.aslan.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int current_layer_size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<current_layer_size;i++){
				TreeNode top = queue.poll();
				list.add(top.val);
				if(top.left!=null){
					queue.offer(top.left);
				}
				if(top.right!=null){
					queue.offer(top.right);
				}
				
			}
			res.add(list);
		}
		return res;
    }
}
