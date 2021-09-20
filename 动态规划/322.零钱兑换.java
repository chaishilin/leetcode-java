import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i] 总金额为i时的最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);//最多硬币个数肯定是amount个，因此再+1表示为无穷大
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int c : coins) {
                if (i >= c) {
                    //比较各种差c块钱的情况
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            //如果为去穷大
            return -1;
        }
        return dp[amount];
    }
}
// @lc code=end

