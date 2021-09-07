import java.util.Arrays;

import jdk.vm.ci.meta.Assumptions.ConcreteMethod;

/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        
        //方法一 一维dp
        // dp[i] 总金额为i时的组合数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;// base case
        // 循环的顺序也很重要，先看只使用前n个硬币时，凑齐各个金额能有多少种
        // 在此基础上，再多加一种硬币，看看凑齐各个金额能有多少种
        // 而不是
        // 把所有类型的硬币给你，因为总金额为n的情况很难从总金额为n-1的情况这样递推，容易导致重复
        // 重复情况：两块钱是1+1和2，三块钱是1+1+1、2+1和1+2，就重复了
        for (int c : coins) {
            for (int i = 1; i < amount + 1; i++) {
                if (i >= c) {
                    dp[i] += dp[i - c];
                }
            }
        }
        return dp[amount];
        
    }

}
// @lc code=end
