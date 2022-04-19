package 字符串;
/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {//从前往后，从后往前，两次循环
            if (s.charAt(i) == c) {
                num = 0;
            } else if (num < Integer.MAX_VALUE) {
                num++;//计算距离上一个字母c的距离
            }
            result[i] = num;
        }
        num = Integer.MAX_VALUE;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == c) {
                num = 0;
            } else if (num < Integer.MAX_VALUE) {
                num++;
            }
            result[j] = Math.min(num, result[j]);
        }
        return result;
    }
}
// @lc code=end

