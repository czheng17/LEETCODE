package com.aslan.easy;

public class L_83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode first = head;
		if(head == null){
		    return null;
		}
		if(head.next == null){
		    return head;
		}
		ListNode second = head.next;
		while(first.next != null){
			if(first.val == second.val){
			    if(second.next == null){
			        first.next = null;
			        return head;
			    }
			    else{
    				first.next = first.next.next;
    				second = first.next;
			    }
			}
			else if(first.val!=second.val){
				first=first.next;
				second = first.next;
			}
			
		}
		return head;  
    }
}
