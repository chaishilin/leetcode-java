/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        //用异或或实现无进位加法，用与实现进位结果
        while (a != 0) {
            int temp = (a & b) << 1;//与
            b = a ^ b;//异或
            a = temp;
        }
        return b;

    }
}
// @lc code=end

