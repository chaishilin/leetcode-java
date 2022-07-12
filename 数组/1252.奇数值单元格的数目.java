package 数组;
/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        /**
         * 数学问题
         * 先记录每一行每一列的奇数个数
         */
        int[] x = new int[m];
        int[] y = new int[n];
        for (int[] item : indices) {
            x[item[0]] += 1;
            y[item[1]] += 1;
        }
        int xOddCount = 0;
        int yOddCount = 0;
        for (int i = 0; i < m; i++) {
            if (x[i] % 2 == 1) {
                xOddCount += 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (y[i] % 2 == 1) {
                yOddCount += 1;
            }
        }
        //奇数行再加一个偶数列，最终结果肯定是奇数，偶数行加奇数列，最终也是奇数
        return xOddCount * (n - yOddCount) + yOddCount * (m - xOddCount);
    }
}
// @lc code=end
