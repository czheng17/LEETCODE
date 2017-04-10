package com.aslan.easy;
/*
 * 
 * 这道题是给了一些二维坐标，现在需要找出一个i，j，k的三元组数量，其中i-j和i-k的距离一致

方法比较简单暴力，i遍历所有点 
每个i同时再次遍历所有点，记录下i-j的距离 
这一轮中此时如果之前遍历过的点（k）有距离和i-j一样的，那么数量+2（j k可以互换）
 * 
 * */
import java.util.HashMap;
import java.util.Map;

public class L_447 {
    // public int numberOfBoomerangs(int[][] points) {
    //     int count = 0;
    //     int n = points.length;
    //     // 直接统计距离过来就可以
    //     for (int i = 0; i < n; i++) {
    //         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //         for (int j = 0; j < n; j++) {
    //             if(i==j){
    //                 continue;
    //             }
    //             int dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
    //             if (!map.containsKey(dis)) {
    //                 map.put(dis, 0);
    //             }
    //             //两个位置可以j k可以颠倒
    //             count += map.get(dis) * 2;
    //             map.put(dis, map.get(dis) + 1); 
    //         }
    //     }
    //     return count;
    // }
    public int numberOfBoomerangs(int[][] points) {
    int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<points.length; i++) {
        for(int j=0; j<points.length; j++) {
            if(i == j)
                continue;
            
            int d = getDistance(points[i], points[j]);                
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        
        for(int val : map.values()) {
            res += val * (val-1);
            System.out.println(res);
        }            
        map.clear();
    }
    
    return res;
}

private int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];
    
    return dx*dx + dy*dy;
}
}
