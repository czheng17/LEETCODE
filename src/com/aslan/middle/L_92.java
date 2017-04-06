package com.aslan.middle;

public class L_92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==n || head.next==null){
        	return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        //让res从哨兵开始就是为了让head第一个位置能有个pre!!
        ListNode pre = res;
        
        for(int i=1;i<m;i++){
        	pre = pre.next;
        }
        ListNode mnode = pre.next;
        for(int i=m;i<n;i++){
        	ListNode cur = mnode.next;
        	mnode.next = cur.next;
        	cur.next = pre.next;
        	pre.next = cur;
        }
        return res.next;
    }
}
