package com.aslan.again;



public class L_101 {
	public boolean isSymmetric(TreeNode root){
		if(root==null){
			return true;
		}
		return this.recur(root.left,root.right);
	}
	
	private Boolean recur(TreeNode left, TreeNode right){
		if(left==null && right==null){
			return true;
		}
//		if(left==null || right==null){
//			return false;
//		}
//		if(left.val != right.val){
//			return false;
//		}
//		
		if(left!=null && right!=null & left.val==right.val){
			return this.recur(left.left, right.right) && this.recur(left.right, right.left);
		}
		return false;
		
	}
}
