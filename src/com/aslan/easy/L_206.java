package com.aslan.easy;

public class L_206 {
//    public ListNode reverseList(ListNode head) {
//
//        if (head == null) {
//            return null;
//        }
//
//        if (head.next == null) {
//            return head;
//        }
//
//        ListNode tail = head.next;
//        ListNode reversed = reverseList(head.next);
//
//        // 前后翻转tail和head
//        tail.next = head;
//        head.next = null;
//
//        return reversed;
//    }
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next ==null){
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		p.next=null;
		head.next=null;
		while(q!=null){
			p=q;
			q=q.next;
			p.next=head;
			head=p;
		}
		return head;
	}
	
}
