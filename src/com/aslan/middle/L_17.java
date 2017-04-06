package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_17 {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits.length() == 0){
			return res;
		}
		String[] map = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		char[] tmp = new char[digits.length()];
		this.recurrent(0,tmp,digits,map,res);
		return res;
	}
	
	private void recurrent(int index, char[] tmp, String digits, String[] map, List<String> res){
		if(index==digits.length()){
			res.add(new String(tmp));
			return;
		}
		char tmpchar = digits.charAt(index);
		for(int i=0;i<map[tmpchar-'0'].length();i++){ //map[] length 有的是 0 ,有的是 3,有的是 4
			tmp[index] = map[tmpchar-'0'].charAt(i);  // a or b or c
			this.recurrent(index+1, tmp, digits, map, res);
		}
	}
}
