package com.aslan.middle;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * */

public class L_6 {
	public String convert(String s, int nRows) {
		if(nRows==1 || s.length()==1){
			return s;
		}
		//有几行，就建立几个stringbuilder,所以建立stringbuilder数组
		StringBuilder[] sb = new StringBuilder[nRows];
		
		for(int i=0;i<nRows;i++){
			sb[i] = new StringBuilder();
		}
		boolean reverse = false;
		
		for(int i=0;i<s.length();i++){
			if(i % (nRows - 1) == 0)
                reverse = !reverse;
			if(reverse==true){
				sb[i % (nRows - 1)].append(s.charAt(i));
			}
			else{
				sb[nRows-1 - (i % (nRows - 1))].append(s.charAt(i));
			}
		}
		
		//把sb[1]到sb[最后] append 到sb[0]后
		for(int i=1;i<nRows;i++){
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}
}
