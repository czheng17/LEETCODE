package com.aslan.easy;

public class L_234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
        	return true;
        }
        ListNode p=head;
        ListNode prev = new ListNode(head.val);
        while(p.next!=null){
        	ListNode tmp = new ListNode(p.next.val);
        	tmp.next=prev;
        	prev = tmp;
        	p=p.next;
        }
        
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while(p1.next!=null){
        	if(p1.val != p2.val){
        		return false;
        	}
        	p1=p1.next;
        	p2=p2.next;
        }
        return true;
    }
}
