/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        //当前如果是奇数，则比特位数为上一个数字加一，
        //如果是偶数，则比特位数为该数字除以二之前的位数
        int[] result = new int[n+1];
        result[0] = 0;
        for (int i = 1; i <= n; i += 1) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = result[i/2];
            }
        }
        return result;

    }
}
// @lc code=end

