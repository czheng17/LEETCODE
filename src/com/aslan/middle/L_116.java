package com.aslan.middle;


public class L_116 {
	public class TreeLinkNode {
	     int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	}
	
    public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        TreeLinkNode linknode;
        while(root.left!=null){
        	linknode = root; //linknode是当前的root
        	//linknode.next = root.right;
        	while(linknode !=null){
        		linknode.left.next = linknode.right; //当前节点的左孩子的next 就是当前节点的右孩子，没毛病
        		if(linknode.next!=null){
        			linknode.right.next = linknode.next.left; //当前节点的右孩子的next 就是当前节点的next的左孩子
        		}
        		linknode = linknode.next;  //类似于BFS,遍历这一层的所有
        	}
        	root = root.left;//下一层
        }
    }
}
