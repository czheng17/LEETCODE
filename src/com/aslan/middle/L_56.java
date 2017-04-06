package com.aslan.middle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Given [1,3],[2,6],[8,10],[15,18],
   return [1,6],[8,10],[15,18].
 * 
 * **/
import java.util.List;

public class L_56 {
	//自己实现出来的，鼓掌！！！
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0){
        	return intervals;
        }
        
        Collections.sort(intervals,new Comparator<Interval>() {
        	public int compare(Interval a, Interval b){
        		return a.start - b.start;
        	}
		});
        
        List<Interval> res= new ArrayList<>();
        
        int preStart=intervals.get(0).start;
        int preEnd = intervals.get(0).end;
        
        for(int i=1;i<intervals.size();i++){
        	if(preEnd<intervals.get(i).start){
        		Interval tmp = new Interval();
        		tmp.start = preStart;
        		tmp.end = preEnd;
        		res.add(tmp);
        		preStart = intervals.get(i).start;
        		preEnd = intervals.get(i).end;
        	}else{
        		preEnd = Math.max(preEnd, intervals.get(i).end);
        	}
        }
        Interval tmp = new Interval();
		tmp.start = preStart;
		tmp.end = preEnd;
		res.add(tmp);
        return res;
    }
}
