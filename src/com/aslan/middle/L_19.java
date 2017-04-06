package com.aslan.middle;
/*
 * Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * */
public class L_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode second = head;
		for(int i=0;i<n;i++){
			second = second.next;
			if(second == null){
			    return head.next;
			}
		}
		
		while(second.next!=null){
			first=first.next;
			second = second.next;
		}
		first.next = first.next.next;
		return head;
    }
}
