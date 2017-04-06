package com.aslan.middle;
/*
 *  
 * 5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 * 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_508 {
	Map<Integer,Integer> map = new HashMap<>();
	
    public int[] findFrequentTreeSum(TreeNode root) {
    	TreeNode first_node =root;
    	this.recur(root);
    	
    	root = first_node;
    	this.inorder(root);
    	
    	int max_frequent = 0;
    	for(int i:map.values()){
    		if(i>max_frequent){
    			max_frequent=i;
    		}
    	}
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
        	if(entry.getValue()==max_frequent){
        		list.add(entry.getKey());
        	}
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
        	res[i] = list.get(i);
        }
        return res;
    }
    private int recur(TreeNode root){
    	if(root==null){
    		return 0;
    	}
    	
    	int left = this.recur(root.left);
    	//System.out.println("left="+left);
    	int right = this.recur(root.right);
    	//System.out.println("right="+right);
    	root.val = left + right + root.val;
    	return root.val;
    }
    private void inorder(TreeNode root){
    	if(root==null){
    		return;
    	}
    	this.inorder(root.left);
    	if(!map.containsKey(root.val)){
    		map.put(root.val, 0);
    	}
    	else{
    		map.put(root.val, map.get(root.val)+1);
    	}
    	//map.put(root.val, map.getOrDefault( map.get(root.val)+1 , 0 ));
    	this.inorder(root.right);
    }
    
}
