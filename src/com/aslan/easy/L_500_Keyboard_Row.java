package com.aslan.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Given a List of words, return the words that can be typed using letters 
 * of alphabet on only one row's of American keyboard like the image below.
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
	Output: ["Alaska", "Dad"]
	题目：给一个数组，看看数组里那些单词的单词组成都在键盘的同一行
	hello hll在ASDFGHJKL eo在QWERTYUIOP,所以不对
	Alaska 都在ASDFGHJKL,所以对
	Dad 都在ASDFGHJKL,所以对
	Peace pee在QWERTYUIOP a在ASDFGHJKL所以不对
	
 * */
public class L_500_Keyboard_Row {
	public String[] findWords(String[] words) {
        String[] Str = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<Str.length; i++) {
            for(char c : Str[i].toCharArray()) {
                map.put(c, i);
            }
        }
        int index = 0;
        List<String> res = new ArrayList<>();
        for(String word : words) {
            if (word.equals("")) continue;
            index = map.get(word.toUpperCase().toCharArray()[0]);
            for(char c : word.toUpperCase().toCharArray()) {
                if(map.get(c) != index) {
                    index = -1;//不用设置flag 直接把index设为-1即可
                    break;
                }
            }
            if(index != -1) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
