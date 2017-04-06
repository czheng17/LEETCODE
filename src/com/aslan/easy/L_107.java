package com.aslan.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> list = new ArrayList<Integer>();
			int current_layer_size = queue.size();
			for(int i = 0;i<current_layer_size;i++){
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
		
		Collections.reverse(res);
		return res;
    }
}
