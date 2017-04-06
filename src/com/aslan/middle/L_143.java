package com.aslan.middle;

public class L_143 {
	
	 public void reorderList(ListNode head) {
	        if(head == null){
	            return;
	        }
	    	ListNode mid_node  = head;
	    	ListNode last_node = head;
	        ListNode come_to_final =head;
	    	while(come_to_final.next!=null && come_to_final.next.next!=null){
	    		mid_node = mid_node.next;
	    		come_to_final = come_to_final.next.next;
	    	}
	    	last_node = mid_node.next;
	    	mid_node.next=null;
	    	mid_node = reverseList(last_node);
	    	
	    	ListNode cur = head;
	    	while(mid_node!= null){
	    		ListNode node = cur.next;
	    		cur.next = mid_node;
	    		mid_node = mid_node.next;
	    		cur.next.next=node;
	    		cur = cur.next.next;
	    	}
	    	
	    	
	    }
	    
	    public ListNode reverseList(ListNode head) {
	    	ListNode prehead = new ListNode(Integer.MAX_VALUE);
	    	while(head!=null){
	    		ListNode temp = prehead.next;
	    		prehead.next = head;
	    		head = head.next;
	    		prehead.next.next = temp;
	    	}
	    	return prehead.next;
	    }
    
    
    
    
//    public void reorderList(ListNode head) {
//    	ListNode midNode = head;
//    	ListNode lastNode = head;
//    	//找到链表的中点
//    	while(lastNode.next != null && lastNode.next.next != null) {
//    		midNode = midNode.next;
//    		lastNode = lastNode.next.next;
//    	}
//    	
//    	lastNode = midNode.next;
//    	//断开链表
//    	midNode.next = null;
//    	
//    	
//    	//反转后半链表
//    	midNode = reverseList(lastNode);
//    	
//    	//合并链表
//    	ListNode cur = head;
//    	while( midNode != null) {
//    		ListNode node = cur.next;
//    		cur.next = midNode;
//    		midNode = midNode.next;
//    		cur.next.next=node;
//    		cur = cur.next.next;
//    	}
//    }
//    
//    public ListNode reverseList(ListNode head) {
//    	ListNode preHead = new ListNode(Integer.MAX_VALUE);
//    	while(head != null) {
//    		ListNode node = preHead.next;
//    		preHead.next = head;
//    		head = head.next;
//    		preHead.next.next = node;
//    	}
//    	return preHead.next;
//    }

}
