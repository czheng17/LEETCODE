package com.aslan.middle;
/*
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
	]
 */
import java.util.ArrayList;
import java.util.List;

public class L_120 {

//	public int minimumTotal(List<List<Integer>> triangle) {
//
//        if (triangle == null || triangle.size() < 1) {
//            return 0;
//        }
//        // 创建数组的第一维度
//        int[][] minSum = new int[triangle.size()][];
//
//        // 创建数组的第二维度
//        for (int i = 0; i < minSum.length; i++) {
//            minSum[i] = new int[i + 1];
//            //i=0 [2]=1
//            //i=1 [3,4]=2
//            //i=2 [6,5,7]=3
//            //i=4 [4,1,8,3]=4
//        }
//        // 设置第一行
//        minSum[0][0] = triangle.get(0).get(0);
//        System.out.println( minSum[0][0]);
//        // 设置其它行
//        //因为第一行已经设置过了，所以嘿嘿，i=1开始
//        for (int i = 1; i < minSum.length; i++) {
//            List<Integer> line = triangle.get(i);
//            //得到每一行的List，比如[3,4],[6,5,7]
//            for (int j = 0; j < minSum[i].length; j++) {
//            	//minSum[1].length=2 --->走两遍
//            	//minSum[2].length=3 --->走三遍
//            	//minSum[3].length=4 --->走四遍
//            	System.out.println("--------->"+minSum[i].length);
//                if (j == 0) {
//                	//第i行的第1个元素 = list的第一个元素+上一行的第一个元素
//                    minSum[i][0] = line.get(0) + minSum[i - 1][0];
//                    System.out.println("line.get(0)="+line.get(0));
//                    System.out.println("i="+i+" j="+j+" result="+minSum[i][0]);
//                } else if (i == j) {
//                    minSum[i][j] = line.get(j) + minSum[i - 1][j - 1];
//                    System.out.println("i="+i+" j="+j+" result="+minSum[i][j]);
//                } else if (j < i) {
//                    minSum[i][j] = line.get(j) + Math.min(minSum[i - 1][j], minSum[i - 1][j - 1]);
//                    System.out.println("test min : i="+(i-1)+" j="+j+" result="+minSum[i-1][j]);
//                    System.out.println("test min : i="+(i-1)+" j="+(j-1)+" result="+minSum[i-1][j-1]);
//                    System.out.println("i="+i+" j="+j+" result="+minSum[i][j]);
//                }
//            }
//        }
//        //找最后一行的最小值就是所求的解
//        int min = minSum[minSum.length - 1][0];
//        int length = minSum[minSum.length - 1].length;
//        for (int i = 1; i < length; i++) {
//            if (min > minSum[length - 1][i]) {
//                min = minSum[length - 1][i];
//            }
//        }
//
//        return min;
//    }
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()<1 || triangle==null){
			return 0;
		}
		int[][] minSum = new int[triangle.size()][triangle.size()];
		
		for(int i =0;i<triangle.size();i++){
			minSum[0][i]=triangle.get(0).get(0);
		}
		for(int i =1;i<triangle.size();i++){
			List<Integer> column_node = new ArrayList<Integer>();
			column_node = triangle.get(i);
			//System.out.println(column_node.get(0));
			
			for(int j = 0;j<triangle.size();j++){
				if(j==0){
					minSum[i][j]=column_node.get(0)+minSum[i-1][0];
				}
				else if(j<=i){
					minSum[i][j] = column_node.get(j)+Math.min(minSum[i-1][j-1], minSum[i-1][j]);

				}
				else if(j>i){
					minSum[i][j]=minSum[i][i];
				}
			}
		}
		
		int min = minSum[triangle.size()-1][0];
		for(int i =1;i<triangle.size();i++){
			if(minSum[triangle.size()-1][i]<min){
				min = minSum[triangle.size()-1][i];
			}
			
		}
		for(int i=0;i<triangle.size();i++){
			for(int j=0;j<triangle.size();j++){
				System.out.print(" "+minSum[i][j]);
			}
			System.out.println();
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		L_120 l = new L_120();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> small_list = new ArrayList<Integer>();
		small_list.add(2);
		list.add(small_list);
		small_list.add(3);
		small_list.add(4);
		list.add(small_list);
		small_list.add(6);
		small_list.add(5);
		small_list.add(7);
		list.add(small_list);
		small_list.add(4);
		small_list.add(1);
		small_list.add(8);
		small_list.add(3);
		list.add(small_list);
		int a = l.minimumTotal(list);
		System.out.println(a);
	}
}
