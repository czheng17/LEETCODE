package com.aslan.middle;

public class L_24 {
	public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
        	return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode mnode = head;
        while(mnode!=null && mnode.next!=null){
        	ListNode cur = mnode.next;
        	mnode.next = cur.next;
        	cur.next = mnode;
        	pre.next = cur;
        	pre = mnode;
        	mnode = mnode.next;
        }
        return res.next;
    }
}
