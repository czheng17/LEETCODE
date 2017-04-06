package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L_20 {
    public boolean isValid(String s) {
        if(s==null || s.length() %2 ==1){
        	return false;
        }
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        char[] s_char = s.toCharArray();
        for(int i=0;i<s_char.length;i++){
        	if(map.containsKey(s_char[i])){
        		stack.push(s_char[i]);
        	}else if(map.values().contains(s_char[i])){
        		if(!stack.isEmpty() && map.get(stack.peek())==s_char[i]){
        			stack.pop();
        		}
        		else{
        			return false;
        		}
        	}
        }
        return stack.empty();
    }
}
