package com.aslan.middle;
/*
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.

	Return a deep copy of the list.
	这是一道链表操作的题目，要求复制一个链表，不过链表的每个结点带有一个随机指针，指向某一个结点。
我们先介绍一种比较直接的算法，思路是先按照复制一个正常链表的方式复制，复制的时候把复制的结点做一个HashMap，
以旧结点为key，新节点为value。这么做的目的是为了第二遍扫描的时候我们按照这个哈希表把结点的随机指针接上。
这个算法是比较容易想到的，总共要进行两次扫描，所以时间复杂度是O(2*n)=O(n)。空间上需要一个哈希表来做结点的映射，
所以空间复杂度也是O(n)。代码如下： 
 * */

import java.util.HashMap;
import java.util.Map;

public class L_138_Copy_List_with_Random_Pointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return head;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode pre = newHead;
		RandomListNode node = head.next;
		while(node != null){
			RandomListNode newNode = new RandomListNode(node.label);
			map.put(node, newNode);
			node = node.next;
			pre.next = newNode;
			pre = newNode;
		}
		node = head;
		RandomListNode copyNode = newHead;
		while(node != null){
			copyNode.random = map.get(node.random);
			copyNode = copyNode.next;
			node = node.next;
		}
		return newHead;
        
    }
}

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
};
