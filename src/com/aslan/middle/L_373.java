package com.aslan.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class L_373 {
	  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
			List<int[]> res = new ArrayList<int[]>();
		    if(nums1.length==0 || nums2.length==0 || k==0){
		    	return res;
		    }
		    Queue<int[]> queue = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
		    	public int compare(int[] a1, int[] a2){
		    		int tmp1 = a1[0] +a1[1];
		    		int tmp2 = a2[0] +a2[1];
		    		return tmp1-tmp2;
		    	}
			});
		    
		    for(int i=0;i<nums1.length;i++){
		    	for(int j=0;j<nums2.length;j++){
		    		int[] save = new int[2];
		    		save[0] = nums1[i];
		    		save[1] = nums2[j];
		    		queue.offer(save);
		    	}
		    }
		    while(k-->0){
		    	int[] tmp = queue.poll();
		    	if(tmp==null){
		    		break;
		    	}
		    	res.add(tmp);
		    }
		    return res;
	  }
	
	//方法不对，应该使用优先队列
//    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//    	List<int[]> res = new ArrayList<int[]>();
//        if(nums1.length==0 || nums2.length==0 || k==0){
//        	return res;
//        }
//
////        int a=0;
////        int b=0;
////        this.recurrent(a,b,nums1,nums2,k);
//        for(int i=0;i<nums1.length;i++){
//        	for(int j=0;j<nums2.length;j++){
//        		if(k==0){
//        			Collections.sort(new Comparator<int[]>(){
//			            public int compare(int[] o1,int[] o2){
//			                int tmp1 = o1[0]+o1[1];
//			                int tmp2 = o2[0]+o2[1];
//			
//			                return tmp1 - tmp2;
//			            }            
//        			});
//        			return res;
//        		}
//                int[] save = new int[2];
//        		save[0] = nums1[i];
//        		save[1] = nums2[j];
//        		res.add(save);
//        		k--;
//        	}
//        }
//        return res;
//    }
////    private void recurrent(int a,int b,int[] nums1, int[] nums2, int k){
////    	if(k==0){
////    		return;
////    	}
////    	for(int i=a;i<nums1.length;i++){
////    		for(int j=b+1;j<nums2.length;j++){
////    			
////    		}
////    	}
////    }
}
