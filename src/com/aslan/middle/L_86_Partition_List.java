/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

public class L_86_Partition_List {
	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null){
			return head;
		}
        ListNode first = new ListNode(-1);
        ListNode first_head = first;
        ListNode second = new ListNode(-1);
        ListNode second_head = second;
        while(head != null){
        	if(head.val < x){
        		first.next = head;
        		first = first.next;
        	}
        	else{
        		second.next = head;
        		second = second.next;
        	}
        	head = head.next;
        }
        second.next = null;
        first.next = second_head.next;
        return first_head.next;
    }
	
	public static void main(String[] args) {
		L_86_Partition_List l86 = new L_86_Partition_List();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		a.next = b;
		ListNode res = l86.partition(a, 0);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		System.out.println("finish");
	}
}
