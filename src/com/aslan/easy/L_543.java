package com.aslan.easy;
/*
 * Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * */
public class L_543 {
	
	int diameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		this.getDepth(root);
		return diameter;
	}
	
	private int getDepth(TreeNode root){
		//终止条件一定要有
		if(root == null){
			return 0;
		}
		int left = this.getDepth(root.left);
		int right = this.getDepth(root.right);
		
		diameter = Math.max(diameter, left+right);
		return Math.max(left, right)+1;	
	}
	
	
//	   int diameter = 0;
//
//		public int diameterOfBinaryTree(TreeNode root) {
//			getDepth(root);
//			return diameter;
//		}
//
//		// 此函数是返回树的最大深度
//		private int getDepth(TreeNode root) {
//		    
//			if (root == null)
//				return 0;
//			System.out.println("root.val="+root.val);
//			int l = getDepth(root.left);
//			System.out.println("l="+l);
//			int r = getDepth(root.right);
//			System.out.println("r="+r);
//			diameter = Math.max(diameter, l + r);
//			System.out.println("diameter="+diameter);
//			System.out.println("Math.max(l, r) + 1="+(Math.max(l, r) + 1)+" l="+l+" r="+r);
//			return Math.max(l, r) + 1;
//		}
}
