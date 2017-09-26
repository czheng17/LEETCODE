package com.aslan.middle;

import java.util.Stack;



/*
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string 
"9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal 
serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' 
representing null pointer.

You may assume that the input format is always valid, for example it could never contain 
two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false


 * 
 * */
public class L_331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0){
        	return false;
        }
        Stack<String> stack = new Stack<>();
        for(String s : preorder.split(",")){
        	if(s.equals("#")){
        		while(!stack.isEmpty()&&stack.peek().equals("#")){
        			//见到##就把两个##都去掉
        			stack.pop();
        			//a##是对的， ##是错的
        			if(stack.isEmpty()){
        				return false;
        			}
        			//把a##中的##弄没后整个a##变成#
        			stack.pop();
        		}
        	}
        	stack.push(s);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
	
	//method2
//	public boolean isValidSerialization(String preorder) {
//	    LinkedList<String> stack = new LinkedList<String>();
//	    String[] arr = preorder.split(",");
//	 
//	    for(int i=0; i<arr.length; i++){
//	        stack.add(arr[i]);
//	 
//	        while(stack.size()>=3 
//	            && stack.get(stack.size()-1).equals("#")
//	            && stack.get(stack.size()-2).equals("#")
//	            && !stack.get(stack.size()-3).equals("#")){
//	 
//	            stack.remove(stack.size()-1);
//	            stack.remove(stack.size()-1);
//	            stack.remove(stack.size()-1);
//	 
//	            stack.add("#");
//	        }
//	 
//	    }
//	 
//	    if(stack.size()==1 && stack.get(0).equals("#"))
//	        return true;
//	    else
//	        return false;
//	}
	
}
