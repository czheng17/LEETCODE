package com.aslan.middle;

/*
 * 61. Rotate List  QuestionEditorial Solution  My Submissions
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
把链表连成环，再在特定的位置断开。注意k可能大于链表的长度。
 */
public class L_61 {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null || n ==0){
			return head;
		}
		int length=1;
		ListNode node = head;
		while(node.next != null){
			node = node.next;
			length++;
		}
		int m=n % length;
		int last = m - length;
		while(last>0){
			last--;
			node = node.next;
		}
		head = node.next;
		node.next = null;
		return head;
    }
}
