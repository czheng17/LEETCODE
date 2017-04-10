package com.aslan.middle;
/*
 * 
 *  s = "3[a]2[bc]", return "aaabcbc".
	s = "3[a2[c]]", return "accaccacc".
	s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * */
import java.util.Stack;

public class L_394 {
	public String decodeString(String s) {
		String res = "";
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		int index=0;
		int count=0;
		while(index<s.length()){
			if(Character.isDigit(s.charAt(index))){
				count = count*10 + s.charAt(index) - '0';
				index++;
			}
			else if(s.charAt(index)=='['){
				numStack.push(count);
				count=0;
				strStack.push(res);
				res="";
				index++;
			}
			else if(s.charAt(index)==']'){
				String tmp = strStack.pop();
				int cur_count = numStack.pop();
				for(int j=0;j<cur_count;j++){
					tmp+=res;
				}
				res = tmp;
				index++;
			}
			else{
				res+=s.charAt(index);
				index++;
			}
			
		}
		return res;
	}
	
	
	
	

}
