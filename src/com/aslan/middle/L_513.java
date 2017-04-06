package com.aslan.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 * 
 * */
public class L_513 {
	//一看又是一道BFS题目
    public int findBottomLeftValue(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
        	int cur_size = queue.size();
        	List<Integer> tmp = new ArrayList<>();
        	for(int i=0;i<cur_size;i++){
        		TreeNode poll = queue.poll();
        		
        		tmp.add(poll.val);

        		if(poll.left!=null){
        			queue.offer(poll.left);
        		}
        		if(poll.right != null){
        			queue.offer(poll.right);
        		}
        	}
        	list.add(tmp);
        }

        return list.get(list.size()-1).get(0);

    }

}
