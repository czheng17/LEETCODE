package com.aslan.middle;

public class L_109 {
	public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
        	return null;
        }
        int list_count=0;
        ListNode test_node_head = head;
        while(test_node_head!=null){
        	list_count++;
        	test_node_head=test_node_head.next;
        }
        int[] list = new int[list_count];
        
        int i=0;
        while(head!=null){
        	list[i] = head.val;
        	i++;
        	head=head.next;
        }
        
        return this.change_to_BST(0,list_count,list);
    }
	private TreeNode change_to_BST(int start,int end,int[] list){
		if(start>=end){
			return null;
		}
		int middle = (start+end)/2;
		TreeNode root = new TreeNode(list[middle]);
		root.left = this.change_to_BST(start, middle, list);
		root.right = this.change_to_BST(middle+1, end, list);
		
		return root;
	}
}
