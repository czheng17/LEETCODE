package com.aslan.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_515 {
	//明显是一道数的BFS题目
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
        	return new ArrayList<Integer>();
        }
        
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
        //对list中的每一个小list从小到大排序
        for(int i=0;i<list.size();i++){
        	Collections.sort(list.get(i));
        }
        //取list中每一个小list的最后一个值(也就是最大的值)放进res
        List<Integer> res =new ArrayList<>();
        for(int i=0;i<list.size();i++){
        	res.add(list.get(i).get(list.get(i).size()-1));
        }
        return res;
        
        
    }
}
