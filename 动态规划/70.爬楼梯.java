/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        //其实就是斐波那契数列
        if (n <= 2){
            return n;
        }
        int n0 = 1;
        int n1 = 2;
        for (int j = 0; j < n-2; j += 1) {
            int temp = n0;
            n0 = n1;
            n1 += temp;
        }
        return n1;
    }
}
// @lc code=end

