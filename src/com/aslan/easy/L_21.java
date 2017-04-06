package com.aslan.easy;

public class L_21 {
	
	// my answer
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l1;
		}
		ListNode list = new ListNode(0);
		ListNode head = list;
		while(l1!=null && l2!=null){
			if(l1.val<=l2.val){
				list.next = l1;
				l1 = l1.next;
				list = list.next;
			}else{
				list.next = l2;
				l2 = l2.next;
				list = list.next;
			}
		}
		if(l1!=null){
			list.next = l1;
		}else if(l2!=null){
			list.next = l2;
		}
		return head.next;
	}
	
	//standard answer
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if(l1==null){
//			return l2;
//		}
//		if(l2 == null){
//			return l1;
//		}
//		ListNode head = null;
//		ListNode node = null;
//		while(l1!=null && l2!=null){
//			if(l1.val<=l2.val){
//				if(node == null){
//					node = l1;
//					head = node;
//					l1 = l1.next;
//				}
//				else{
//					node.next=l1;
//					node=node.next;
//					l1 = l1.next;
//				}
//				
//			}else{
//				if(node == null){
//					node = l2;
//					head = node;
//					l2= l2.next;
//				}else{
//					node.next = l2;
//					node = node.next;
//					l2=l2.next;
//				}
//			}
//		}
//		if(l1!=null){
//			node.next=l1;
//		}else if(l2 !=null){
//			node.next=l2;
//		}
//        return head;
//    }
}
