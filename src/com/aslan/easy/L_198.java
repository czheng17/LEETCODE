package com.aslan.easy;


/*
 * 抢还是不抢：
题目需求：一条街有那么五个房子，一个小贼想入室抢劫。走这么一圈后要抢到收益最大化。
ps:不能每个屋子都抢，因为相邻的两间屋子是最多只能抢一个的。

［100，200，100，300，300］
怎么抢呢？ 肯定是200＋300这么抢

［200，100，200，100，300］
200+200+300

［200，100，100，600，100］
200+100+600

［100，200，100，200，600］
200+200+600

思路：
4个变量： 1.在偷第i房子之前，我 偷第（i－1）房子的价值 ＋ （i-1）之前的房子的价值总和（必须是i-3及其以前）； 
        2。在偷这个房子之前，我 没有偷第（i－1）房子的价值 ＋ （i-1）之前的房子的价值总和（可以是i-2）；
        3.抢当前房子
        4.不抢当前房子

        从第一家到最后一家for循环。

        判断： 当前这个房子抢还是不抢？
        抢： 第三个变量 = 第i个房子的价值 + 第二个变量(因为第i-1房子不能抢)
        不抢： 第四个变量 = 第一个变量与第二个变量的那个最大值。
        第一个变量 <- 第三个变量
        第二个变量 <- 第四个变量

	    for循环完毕

	    return 第一个变量和第四个变量的最大值
 * 
 * */



public class L_198 {
	public int rob(int[] nums) {
        int rob_in_the_previous_step = 0;
        int not_rob_in_the_previous_step = 0;

        for(int i=0;i<nums.length;i++){
            int rob_in_the_current_step = not_rob_in_the_previous_step + nums[i];
            int not_rob_in_the_current_step = 0;
            if(rob_in_the_previous_step>not_rob_in_the_previous_step){
                not_rob_in_the_current_step = rob_in_the_previous_step;
            }else{
                not_rob_in_the_current_step = not_rob_in_the_previous_step;
            }

            rob_in_the_previous_step = rob_in_the_current_step;
            not_rob_in_the_previous_step = not_rob_in_the_current_step;
        }
        if(rob_in_the_previous_step>not_rob_in_the_previous_step){
            return rob_in_the_previous_step;
        }else{
            return not_rob_in_the_previous_step;
        }
        //return 0;
    }
	
}
