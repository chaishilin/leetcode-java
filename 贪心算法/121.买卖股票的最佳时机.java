/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minNum = prices[0];
        for (int p : prices) {
            //每次遍历都找目前有的最小价格
            minNum = Math.min(minNum, p);
            //每次遍历都减一下试试
            result = Math.max(result, p - minNum);
        }
        return result;

    }
}
// @lc code=end

