package com.aslan.easy;

public class L_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        return this.whether_or_not_Symmetric(root.left,root.right);
    }
    private boolean whether_or_not_Symmetric(TreeNode left, TreeNode right){
    	if(left==null && right==null){
    		return true;
    	}
    	if(left!=null && right!=null && left.val == right.val){
    		return whether_or_not_Symmetric(left.left,right.right) && whether_or_not_Symmetric(left.right , right.left);
    	}
    	return false;
    }
}
