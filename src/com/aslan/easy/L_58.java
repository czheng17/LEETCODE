package com.aslan.easy;

public class L_58 {
    public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        String[] words = s.split(" ");
        //char[] a = words[words.length-1].toCharArray();
        //return a.length;
        return words[words.length-1].length();
    }
    public static void main(String[] args) {
		L_58 l = new L_58();
		System.out.println(l.lengthOfLastWord("hello world"));
	}
}
