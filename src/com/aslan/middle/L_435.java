package com.aslan.middle;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class L_435 {
//	  public int eraseOverlapIntervals(Interval[] intervals) {
//			// 按照起始位置进行排序
//		    int res=0;
//		    Arrays.sort(intervals,(x,y)->(x.start)-(y.start));
//		    Set<Interval> set = new HashSet<Interval>();
//		    set.add(intervals[0]);
//		    int prestart = intervals[0].start;
//		    int preend = intervals[0].end;
//		    for(int i=1;i<intervals.length;i++){
//		    	Interval cur = intervals[i];
//		    	if(!set.contains(intervals[i])){
//		    		set.add(intervals[i]);
//		    	}else{
//		    		res++;
//		    	}
//		    	if(cur.start==preend){
//		    		if(!set.contains(new Interval(prestart,cur.end))){
//		    			set.add(new Interval(prestart,cur.end));
//		    		}
//		    		else{
//		    			res++;
//		    		}
//		    		preend = cur.end;
//		    	}else{
//		    		prestart = cur.start;
//		    		preend = cur.end;
//		    	}
//		    }
//		    return res;
//	  }

    public int eraseOverlapIntervals(Interval[] intervals) {
    	// 按照起始位置进行排序
        Arrays.sort(intervals,(x,y)->(x.start)-(y.start));
        int count=0,j=0;
        // 贪心法，如果上一个位置j和当前位置i冲突了，那么进行判断，
        // 如果当前位置的末尾小于上一个边界的末尾，那么删除上一个位置
        // （因为覆盖的更少，每步选择最有可能不造成重复的），
        // 反之如果当前位置尾部覆盖的更多，那么就删除i的位置。删除的方式通过控制j的取值进行
        for(int i=1;i<intervals.length;i++) {
            if(intervals[j].end>intervals[i].start){
                j=intervals[i].end<intervals[j].end?i:j;
                count++;
            }else
            //没有重复
                j=i;

        }
        return count; 
    }

}
