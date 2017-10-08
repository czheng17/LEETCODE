package com.aslan.middle;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized 
 * with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.
 * */

public class L_173_Binary_Search_Tree_Iterator {
	TreeNode node = null;
	Stack<TreeNode> stack = new Stack<>();
	
	public L_173_Binary_Search_Tree_Iterator(TreeNode root) {
		node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !( (node==null)&&stack.isEmpty() );
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = null;
        
        if(node == null){
        	res = stack.pop();
        	node = res.right;
        }
        else{
        	while(node.left!=null){
        		stack.push(node);
        		node = node.left;
        	}
        	res = node;
        	node = node.right;
        }
        return res.val;
    }
}
