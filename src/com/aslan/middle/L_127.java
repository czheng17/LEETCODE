package com.aslan.middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
	Only one letter can be changed at a time.
	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 
 * For example,
	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log","cog"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
 * */
public class L_127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //int res=0;
        if(wordList.size()==0){
        	return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        
        queue.offer(beginWord);
        
        if(wordList.contains(beginWord)){
        	wordList.remove(beginWord);
        }
        for(int i = 0; i<wordList.size();i++){
        	map.put(wordList.get(i), 0);
        }
        map.put(beginWord, 1);
        
        while(!queue.isEmpty()){
        	String top = queue.poll();
        	int res = map.get(top);
        	for(int a = 0; a<top.length();a++){
        		StringBuilder sb = new StringBuilder(top);
            	for (char c='a'; c<='z';c++){
            		sb.setCharAt(a, c);
            		if(sb.equals(endWord)){
            			return res+1;
            		}
            		if(sb.equals(top)){
            			continue;
            		}
            		if(map.containsKey(sb.toString())){
            			queue.offer(sb.toString());
            // 			res++;
                        map.put(sb.toString(),res+1);
            			wordList.remove(sb);
            		}
            	}
        	}
        }
        return 0;
    }
	
	
	
	
	
	
	
	
	
/*
 * Finish it long long time ago, but i lready forget how to write, i need to rewrite.
 * */

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    	if(wordList.size() == 0){
//    		return 0;
//    	}
//    	Queue<String> queue = new LinkedList<String>();
//    	queue.add(beginWord);
//    	Map<String,Integer> map = new HashMap<String, Integer>() ;
//    	map.put(beginWord, 1);
//    	if(wordList.contains(beginWord)){
//    		wordList.remove(beginWord);
//    	}
//    	
//    	while(!queue.isEmpty()){
//    		@SuppressWarnings("unused")
//			String top = new String();
//    		top = queue.poll();
//    		int level = map.get(top);
//    		StringBuilder sb = new StringBuilder();
//    		
//    		for(int i=0; i<top.length();i++){
//    			sb = new StringBuilder(top);
//    			for(char a='a';a<='z';a++){
//    				sb.setCharAt(i, a);
//    				String tmp = sb.toString();
//    				System.out.println(tmp);
//    				if(tmp.equals(top)){
//    					continue;
//    				}
//    				if(tmp.equals(endWord)){
//    					return level+1;
//    				}
//    				if(wordList.contains(tmp)){
//    					queue.add(tmp);
//    					map.put(tmp, level+1);
//    					wordList.remove(tmp);
//    				}
//    			}
//    		}
//    	}
//    	
//        return 0;
//    }
}
