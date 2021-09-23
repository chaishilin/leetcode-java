/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < n / 3 + 1; i += 1) {
            if (Math.pow(3,i) == n) {
                return true;
            } else if (Math.pow(3,i) > n) {
                return false;
            }
        }
        return false;

    }
}
// @lc code=end

