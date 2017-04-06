package com.aslan.middle;

public class L_450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null){
			return root;
		}
		if(key>root.val){
			root.right = this.deleteNode(root.right, key);
		}
		else if(key<root.val){
			root.left = this.deleteNode(root.left, key);
		}
		else if(key == root.val){
			if(root.left!=null && root.right!=null){
				//要删除的该点左子树和右子树都在
				root.val = this.findMin(root.right).val;
				root.right = this.deleteNode(root.right, root.val);
			}
			else{
				//要删除的该点只有左子树或者右子数
				if(root.left==null){
					root = root.right;
				}else{
					root = root.left;
				}
			}
		}
		return root;
	}
	//BST的性质告诉我们：树的左子树才能找到最小值
	private TreeNode findMin(TreeNode root){
		TreeNode node = root;
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}
}
