package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_241_Different_Ways_to_Add_Parentheses {
  /*
  Given a string of numbers and operators, return all possible results from computing all the different possible ways 
  to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
分治法！！！！！！！！！
  */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<input.length();i++){
			char cur_char = input.charAt(i);
			if(cur_char=='+'|| cur_char=='-' || cur_char=='*'){
				List<Integer> left = this.diffWaysToCompute(input.substring(0,i));
				List<Integer> right = this.diffWaysToCompute(input.substring(i+1));
				for(int n:left){
					for(int m:right){
						switch (cur_char) {
						case '+':
							res.add(n+m);
							break;
						case '-':
							res.add(n-m);
							break;
						case '*':
							res.add(n*m);
							break;

						}
					}
				}
			}
		}
		if(res.size()==0){
			res.add(Integer.parseInt(input));
		}
		return res;
	}
}
