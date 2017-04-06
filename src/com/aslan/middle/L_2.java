package com.aslan.middle;
/*
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 * */
public class L_2 {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 if(l1==null && l2==null){
			 return null;
		 }
		 if(l1==null && l2 != null){
			 return l2;
		 }
		 if(l1!=null && l2 == null){
			 return l1;
		 }
		 
		 ListNode list = new ListNode(0);
		 ListNode result = list;
		 int jinwei=0;
		 
		 while(jinwei>0 || l1!=null || l2!=null){
			 int l1_val = 0;
			 if(l1!=null){
				 l1_val = l1.val;
				 l1 = l1.next;
			 }
			 
			 int l2_val = 0;
			 if(l2!=null){
				 l2_val = l2.val;
				 l2 = l2.next;
			 }
			 
			 int temp_result = (l1_val +l2_val + jinwei) %10;
			 jinwei = (l1_val +l2_val + jinwei) / 10;
			 list.next = new ListNode(temp_result);
			 list = list.next;
			 
		 }
		 
		 return result.next;
	 }
}
