package com.aslan.middle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * */
public class L_230 {
	
	List<Integer> list = new ArrayList<>();
	
    public int kthSmallest(TreeNode root, int k) {
        this.inorder(root);
        //Collections.sort(list);
        return list.get(k-1);
    }
    private void inorder(TreeNode root){
    	
    		if(root==null){
        		return;
        	}
        	this.inorder(root.left);
        	list.add(root.val);
        	this.inorder(root.right);
    	
    }
}
