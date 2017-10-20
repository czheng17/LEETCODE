package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

题目叫做Ransom Note，勒索信，刚开始我还没理解这个题目的意思，尤其这个标题，和magazine有啥关系呢？
后来仔细想想，才慢慢理解。勒索信，为了不暴露字迹，就从杂志上搜索各个需要的字母，组成单词来表达的意思。这样来说，
题目也就清晰了，判断杂志上的字是否能够组成勒索信需要的那些字符。 
这里需要注意的就是杂志上的字符只能被使用一次，不过不用考虑大小写的问题。 
有一种最简单的理解就是对于ransomNote里每个字符出现的次数必须小于或者等于该字符在magazine出现的次数。

更多的方法我放在了evernote!!
http://blog.csdn.net/styshoo/article/details/52232993
 * 
 * */


public class L_383_Ransom_Note {
	public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> ran_count = new HashMap<>();
        Map<Character,Integer> mag_count = new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            ran_count.put(ransomNote.charAt(i) , ran_count.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(int i=0;i<magazine.length();i++){
            mag_count.put(magazine.charAt(i),mag_count.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(Character ch : ran_count.keySet()){
            if(!mag_count.containsKey(ch) || ran_count.get(ch)>mag_count.get(ch)){
                return false;
            }
        }
        return true;
    }
}
