package com.aslan.middle;
/*
 * Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 * */
public class L_82 {
	//my answer
	public ListNode deleteDuplicates(ListNode head) {
		ListNode  node = new ListNode(0);
		ListNode res = node;
		ListNode first = head;
        if(head == null){
        	return null;
        }
        if(head.next==null){
        	return head;
        }
        ListNode second = head.next;
        int same =-10000;
        while(first.next!=null){
        	if(first.val!=second.val && first.val != same ){
        	    same = first.val;
    			node.next = first;
        		node = node.next;
        		first = first.next;
        		second = first.next;
        	}
        	else{
        	    same = first.val;
        		first = first.next;
        		second = first.next;
        	}
        }
        if(same == first.val){
            node.next=null;
        }else{
            node.next=new ListNode(first.val);
        }
        return res.next;
    }
	
	
	// maybe standard answer
//	public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode helper = new ListNode(0);
//        ListNode pre = helper;
//        boolean isDup = false;
//        while (head != null && head.next != null) {
//            if (head.val == head.next.val) {
//                isDup = true;
//            } else if (isDup) {
//                isDup = false;
//            } else {
//                pre.next = head;
//                pre = pre.next;
//            }
//            head = head.next;
//        }
//        if (!isDup) {
//            pre.next = head;
//            pre = pre.next;
//        } else {
//            pre.next = null;
//        }
//        return helper.next;
//    }
}
