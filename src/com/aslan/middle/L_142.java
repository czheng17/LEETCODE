package com.aslan.middle;

public class L_142 {
	public ListNode detectCycle(ListNode head) {
	       ListNode slow = head;
	       ListNode fast = head;
	       if(head == null || head.next == null){
	    	   return null;
	       }
	       while(fast.next != null && fast.next.next != null){
	    	   slow = slow.next;
	    	   fast = fast.next.next;
	    	   if(slow == fast){
	    		   slow = head;
	    		   while(slow!=fast){
	    			   slow=slow.next;
	    			   fast=fast.next;
	    		   }
	    		   return fast;
	    	   }
	       }
	       return null;
	    }
}
