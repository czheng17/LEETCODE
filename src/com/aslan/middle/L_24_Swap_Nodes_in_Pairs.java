/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;                             //pre  mnode
        ListNode mnode = head;                          // 0  ->  1  ->  2 -> 3 -> 4
        
        while(mnode!=null && mnode.next!=null){         //pre   mnode    cur  cur.next
            ListNode cur = mnode.next;                  // 0  ->  1    ->  2  ->   3  ->  4
            
                                                        // pre  mnode  cur.next
            mnode.next = cur.next;                      // 0 ->   1   ->  3   ->  4
            
                                                        // cur  mnode  
            cur.next = mnode;                           // 2 ->   1   ->  3   ->  4     
           
                                                        // pre   cur   mnode   
            pre.next = cur;                             // 0  -> 2 ->   1   ->  3   ->  4 
            
                                                        //              pre 
            pre = mnode;                                //  0  -> 2 ->   1   ->  3   ->  4 
            
                                                        //              pre     mnode
            mnode = mnode.next;                         //  0  -> 2 ->   1   ->  3   ->  4 
            
        }
        return res.next;
    }
}
