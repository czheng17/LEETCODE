package com.aslan.easy;
/*
 * Given two non-empty binary trees s and t, check whether tree t has exactly the
 *  same structure and node values with a subtree of s. A subtree of s is a tree consists 
 *  of a node in s and all of this node's descendants. The tree s could also be considered 
 *  as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 * */
public class L_572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if(s==null && t!=null){
    		return false;
    	}
        if(issame(s, t)){
        	return true;
        }
        return this.isSubtree(s.left,t) || this.isSubtree(s.right,t);
    }
    private boolean issame(TreeNode s, TreeNode t){
    	if(s==null && t==null){
        	return true;
        }
        if(s==null || t==null){
        	return false;
        }
        // i forget this very important part!! wtf!
        if(s.val != t.val){
        	return false;
        }
        return this.issame(s.left,t.left) && this.issame(s.right,t.right);
    }
}
