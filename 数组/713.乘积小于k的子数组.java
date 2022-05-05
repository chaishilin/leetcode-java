/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
import java.math.BigDecimal;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;//双指针，i在前面
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {//一直往前走，使得乘积小于k
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;//i和j之间的子数组成绩是满足要求的
        }
        return ret;
    }
}
// @lc code=end

