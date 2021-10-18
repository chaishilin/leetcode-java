/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        //num 与其补码之和为距离num最近的2^n-1
        return (int)(long)Math.pow(2,(int) (Math.log(num) / Math.log(2))+1)-1-num;
    }
}
// @lc code=end

