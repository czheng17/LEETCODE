package com.aslan.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * 
 * **/
public class L_332 {
	LinkedList<String> res;
	Map<String,PriorityQueue<String>> map;
	
    public List<String> findItinerary(String[][] tickets) {
    	if(tickets==null || tickets.length==0){
    		return new ArrayList<>();
    	}
    	res = new LinkedList<>();
    	map = new HashMap<>();
    	for(String[] ticket: tickets){
    		if(!map.containsKey(ticket[0])){
    			map.put(ticket[0], new PriorityQueue<>());
    		}
    		map.get(ticket[0]).offer(ticket[1]);
    	}
    	this.dfs_method("JFK");
    	return res;
    }
    private void dfs_method(String str){
    	while(map.containsKey(str) && !map.get(str).isEmpty() ){
    		this.dfs_method(map.get(str).poll());
    	}
    	res.addFirst(str);
    }
}
