package com.aslan.middle;
/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

【题意】

环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站消耗汽油cost[i]，
问从哪个加油站出发能够回到起始点，如果都不能则返回-1（注意，解是唯一的）

两个变量，一个total,一个sum，如果total加起来为负的，说明就是不对
如果sum<0,则说明这一段区域都不是起点

 * 
 * */
public class L_134_Gas_Station {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || gas.length==0 || cost==null || cost.length==0){
        	return -1;
        }
        int sum=0;
        int total=0;
        int start=-1;
        for(int i=0;i<gas.length;i++){
        	total += gas[i] - cost[i];
        	sum += gas[i] - cost[i];
        	if(sum<0){
        		start = i;
        		sum=0;
        	}
        }
        if(total<0){
        	return -1;
        }
        else{
        	return start+1;
        }
    }
}
