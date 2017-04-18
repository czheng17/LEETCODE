package com.aslan.middle;

import java.util.Stack;

public class L_150 {
	public int evalRPN(String[] tokens) {
		int a=0;
		int b=0;
		Stack<Integer> stack = new Stack<>();
		for(String i:tokens){
			if(i.equals("*")){
				a = stack.pop();
				b = stack.pop();
				int c = a*b;
				stack.push(c);
			}
			else if(i.equals("/")){
				b = stack.pop();
				a = stack.pop();
				int c = a/b;
				stack.push(c);
			}
			else if(i.equals("+")){
				a = stack.pop();
				b = stack.pop();
				int c = a+b;
				stack.push(c);
			}
			else if(i.equals("-")){
				b = stack.pop();
				a = stack.pop();
				int c = a-b;
				stack.push(c);
			}
			else{
				stack.push(Integer.valueOf(i));
			}
		}
		return stack.pop();
	}
}
