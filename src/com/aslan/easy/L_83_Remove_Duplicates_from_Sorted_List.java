/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        // int tmp_val = head.val;
        ListNode res = head;
        while(head.next!=null){
            if(head.val == head.next.val && head.next.next != null){
                head.next = head.next.next;
            }
            else if(head.val == head.next.val && head.next.next == null ){
                head.next =null;
                return res;
            }
            else if(head.val != head.next.val){
                head = head.next;
            }
        }
        return res;
        
    }
}
