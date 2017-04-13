package com.aslan.middle;

public class L_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildMyTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }
    
    private TreeNode buildMyTree(int[] preorder,int prestart, int preend, int[] inorder, int instart,int inend){
    	if(prestart>preend || instart>inend){
    		return null;
    	}
    	int rootval = preorder[prestart];
    	int inorder_root_index = 0;
        //preorder [1   2 3 4 6 7]
    	TreeNode root = new TreeNode(rootval);
    	//inorder  [3 2 4   1   6 7] find the index of 1 in inorder
    	for(int i=instart;i<=inend;i++){
    		if(inorder[i]==rootval){
    			inorder_root_index = i;
    			break;
    		}
    	}
    	//[3 2 4 0]   3-0=3
    	int len = inorder_root_index - instart;
    	//pre [1  2 3 4]
    	//in  [3 2 4  1]
    	                      //[1 2 3 4 6 7]  index=1   index = [1 2 3 4] 不变    不变     inorder 1 的 index 
    	root.left = this.buildMyTree(preorder, prestart+1, prestart+len, inorder, instart, inorder_root_index-1);
    	//pre [6 7]
    	//in  [6 7]
    	                                    //left preend的下一个                   [3 2 4 1 6 7]中6的index
    	root.right = this.buildMyTree(preorder, prestart+len+1, preend, inorder, inorder_root_index+1, inend);
    	
    	return root;
    }
}
