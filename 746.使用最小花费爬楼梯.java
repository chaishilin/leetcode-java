import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int result = 0;
        //这种动态规划最小值的题目，都是要找以当前数字为最后结尾的最小值是多少
        int[] recode = new int[cost.length];
        recode[0] = cost[0];
        recode[1] = cost[1];
        for (int i = 2; i < cost.length; i += 1) {
            recode[i] = Math.min(recode[i - 2] + cost[i], recode[i - 1]+cost[i]);
        }
        for(int r:recode)
            System.out.println(r);
        //从最后一格和最后两格过来的都可以
        return Math.min(recode[cost.length-1],recode[cost.length-2]);


    }
}
// @lc code=end

