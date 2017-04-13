package com.aslan.middle;

public class L_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return this.buildMyTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
	
	private TreeNode buildMyTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend){
		if(instart>inend || poststart>postend){
			return null;
		}
		
		int rootval = postorder[postend];
		TreeNode root =new TreeNode(rootval);
		
		int inorder_root_index=0;
		for(int i=instart;i<=inend;i++){
			if(inorder[i]==rootval){
				inorder_root_index = i;
				break;
			}
		}
		int len = inorder_root_index - instart;
		
		root.left = this.buildMyTree(inorder, instart, inorder_root_index-1, postorder, poststart, poststart+len-1);
		
		root.right = this.buildMyTree(inorder, inorder_root_index+1, inend, postorder, poststart+len, postend-1);
		
		return root;
	}
}
