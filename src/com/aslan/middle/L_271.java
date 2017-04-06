package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_271 {
	public String encode(List<String> strs){
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < strs.size();i++){
			String tmp = strs.get(i);
			output.append(tmp.length()+"#");
			output.append(tmp);
		}
		return output.toString();
	}
	public List<String> decode(String s){
		List<String> list = new ArrayList<String>();
		int i =0;
		while(i<s.length()){
			int index = s.indexOf('#',i);
			System.out.println("index position:" +index);
			int size = Integer.parseInt(s.substring(i,index));
			list.add(s.substring(index+1,index+1+size));
			i = index+1+size;
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		list.add("aslan");
		list.add("zheng");
		list.add("chen");
		L_271 sol = new L_271();
		String tmp = sol.encode(list);
		System.out.println(tmp);
		res = sol.decode(tmp);
		System.out.println("final result:");
		for(int i = 0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
}
