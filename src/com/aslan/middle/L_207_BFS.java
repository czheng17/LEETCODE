package com.aslan.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class L_207_BFS {
	public boolean canFinish(int numCourse, int[][] prequisities){
		if(numCourse == 1){
			return true;
		}
		if(prequisities.length == 0 || prequisities[0].length == 0){
			return true;
		}
		// build up map;
		Map<Integer,Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for(int i=0; i <numCourse;i++){
			map.put(i, new HashSet<Integer>());
		}
		for(int i=0; i < prequisities.length; i++){
			map.get(prequisities[i][0]).add(prequisities[i][1]);
		}
		
		// begin bfs
		Queue<Integer> queue = new LinkedList<Integer>();
		int numRemaining = numCourse;
		for(Entry<Integer, Set<Integer>> entry: map.entrySet()){
			if(entry.getValue().size() == 0){
				queue.offer(entry.getKey());
				numRemaining--;
			}
		}
		while(!queue.isEmpty()){
			int key = queue.poll();
			for(Entry<Integer,Set<Integer>> entry:map.entrySet()){
				if(entry.getValue().contains(key)){
					entry.getValue().remove(key);
					if(entry.getValue().size()==0){
						queue.offer(entry.getKey());
						numRemaining--;
					}
				}
			}
		}
		return numRemaining == 0;
	}
	
	public static void main(String[] args) {
		L_207_BFS sol = new L_207_BFS();
		int[][] test1 = {{0,1},{1,2}};
		System.out.println(sol.canFinish(3, test1));
		int[][] test2 = {{0,1},{1,0}};
		System.out.println(sol.canFinish(2, test2));
	}
}
