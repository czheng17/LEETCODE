package com.aslan.middle;

import java.util.Arrays;
import java.util.List;

public class L_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] pos = new int[s.length()+1];
		Arrays.fill(pos, -1);
		pos[0] = 0;
		for(int i=0;i<s.length();i++){
			if(pos[i] != -1){
				for(int j=i+1;j<=s.length();j++){
					String tmp = s.substring(i,j);
					if(wordDict.contains(tmp)){
						pos[j] = i;
					}
				}
			}
		}
		return pos[pos.length-1] != -1;
	}
}
