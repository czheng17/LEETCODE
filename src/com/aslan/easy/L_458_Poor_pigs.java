package com.aslan.easy;
/*
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. 
 * They all look the same. If a pig drinks that poison it will die within 15 minutes. 
 * What is the minimum amount of pigs you need to figure out which bucket contains 
 * the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:

If there are n buckets and a pig drinking poison will die within m minutes, 
how many pigs (x) you need to figure out the "poison" bucket within p minutes? 
There is exact one bucket with poison.
 * 
 * 这道题就是思维题。
假设我们有 2 头猪，毒需要15分钟才能杀死猪，我们总共有60分钟。那么，用下列方式，我们能至多从25个桶中找到毒水。 
把桶放置成 5×5 的方形:

 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
使用一头猪来找毒水的行数 (让它喝下桶 1, 2, 3, 4, 5, 里的水，等15分钟；让它喝下桶 6, 7, 8, 9, 10, 里的水，等15分钟......)。
使用另一头猪来找毒水的列数 (让它喝下桶 1, 6, 11, 16, 21, 里的水，等15分钟；让它喝下桶 2, 7, 12, 17, 22, 里的水，
等15分钟......)。

拥有60分钟，每次毒水测试需要15分钟，意味着我们可以进行4次测试。从 0min 开始第一波测试，第15min 出 0 的结果并进行第二波测试，
第 30min 出15 的结果并进行第三波测试，第 45min 出 30 的结果并进行第4波测试。第 60min 出 45 的结果。
如果 行猪 在第三次测试中死亡，那么毒水就在第3行。如果 列猪 在4次测试中都没死，那么毒水在它没喝的第5列中。
（这就是为什么只能做4波测试，却能够测试5行/列）。

如果有3头猪，可以用 5×5×5 正方体，使用一头猪来测试一个维度：猪1 从上到下 喝一层层的水，猪2 从左向右 喝，猪3  从前向后 喝。
所以三头猪最多能测试125个桶。

总的来说, 用这种方式，我们能测试 (⌊minutesToTest / minutesToDie⌋ + 1)pigs 个桶。
 * */
public class L_458_Poor_pigs {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		if(buckets==1){
			return 0;
		}
		int len = minutesToTest/minutesToDie + 1;
		int total = len;
		int number_pigs=1;
		while(total<buckets){
			total = total * len;
			number_pigs++;
		}
		return number_pigs;
	}
}
