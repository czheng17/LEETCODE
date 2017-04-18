package com.aslan.easy;
/**
 *  Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * 
 * **/
public class L_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
        	return head;
        }
        while( head != null && head.val==val ){
        	head=head.next;
        }
        ListNode list = head;
        while(head != null && head.next!=null){
        	if(head.next.val==val){
        		head.next = head.next.next;
        	}
        	else 
        	    head = head.next;
        }
        return list;
    }
}
