package com.aslan.middle;

import java.util.Stack;
/*
 * Given a string containing only three types of characters: '(', ')' and '*', 
 * write a function to check whether this string is valid. We define the validity of a string 
 * by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or 
an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True

solution: use two stack , first put ( , second put *, record the position index, if ( > * --> )( -->wrong
 * 
 * */
public class L_678_Valid_Parenthesis_String {
	public boolean checkValidString(String s) {
        Stack<Integer> left_stack = new Stack<>();
        Stack<Integer> star_stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp=='('){
                left_stack.push(i);
            }else if(tmp=='*'){
                star_stack.push(i);
            }
            else{
                if(left_stack.isEmpty() && star_stack.isEmpty()){
                    return false;
                }
                else if(!left_stack.isEmpty()){
                    left_stack.pop();
                }
                else{
                    star_stack.pop();
                }
            }
        }
        while(!left_stack.isEmpty() && !star_stack.isEmpty()){
            if(left_stack.pop() > star_stack.pop()){
                return false;
            }
        }
        return left_stack.isEmpty();
    }
}
