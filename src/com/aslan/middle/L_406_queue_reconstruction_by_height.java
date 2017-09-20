package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

import javax.print.attribute.standard.RequestingUserName;

/*
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people 
 * in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.

Note: 
The number of people is less than 1,100. 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
1
2
3
4
5
思路： 
先按照高度从大到小排序，高度h相同的，将k比较小的放在前面。 
排完序之后的结果为[7,0],[7,1][6,1][5,0][5,2][4,4]

接下来要调整整个队列，从第二个开始， 
1）如[7,1] 允许比其大的一个数在其前面，那么[7,1]的位置可以不变 
调整完后 
[7,0],[7,1][6,1][5,0][5,2][4,4]

2）调整[6,1], 允许一个大于或者等于6的数在前面，那么就将[6,1] 
插入到索引为1的地方 
[7,0],[6,1][7,1][5,0][5,2][4,4]

3）调整[5,0],允许0个大于或者等于5的数在前面，将[5,0]插入在索引为0的地方 
[5,0][7,0],[6,1][7,1][5,2][4,4]

4）调整[5,2],允许2个大于或者等于5的数在前面，将[5,2]插入在索引为2的地方 
[5,0][7,0],[5,2][6,1][7,1][4,4]

5）调整[4,4]，可允许4个大于或者等于4的数在前面，将[4,4]插入在索引为4的地方 
[5,0][7,0],[5,2][6,1][4,4][7,1]

最后即为最后的结果。

总结：先按照高度从大到小的排序，就是保证在调整某个people的时候，
前面的高度都是比自己高的，将自己插入到高度比自己高的人前面的时候，对前面的人也不会产生太大的影响，前面的人不会被自己挡住。


先对已有的数组进行排序。按照高度降序排列，如果高度一样，按照k的值升序排列。这样比如一开始[7，0] [7，1] [7，2]就会排好，
然后比如说后面有一个[6，1]， 说明只有一个大于或等于它，又因为比6大的已经全部取出。所以把它放在位置1，
这样就变成[7，0] [6，1] [7，1] [7，2].然后比如又有一个[5，0].就放在位置0，以此类推。

即对于案列。首先排序成：

{[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
然后对于第二个数字进行插入对应位置：

[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * */
public class L_406_queue_reconstruction_by_height {
	public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0){
        	return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
        	public int compare(int[] p1,int[] p2){
        		if(p1[0]==p2[0]){
        			return p1[1] - p2[1];
        		}
        		else{
        			return p2[0] - p1[0];
        		}
        	}
		});
        
        List<int[]> list = new ArrayList<>();
        for(int[] one_people : people){
        	if(people.length == one_people[1]){
        		list.add(one_people);
        	}
        	else{
        		list.add(one_people[1], one_people);
        	}
        }
        int[][] res = new int[people.length][2];
        for(int i=0; i<list.size();i++){
        	res[i] = list.get(i);
        }
        return res;
    }
}
