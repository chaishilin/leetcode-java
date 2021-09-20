/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            //不断获得sum：sum为以当前数字num为最后一个数字的最大子序和；
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            //然后通过result比较获得以各个数字为最后一个数字的各个子序和，找到最大的即可。
            result = Math.max(result, sum);
        }
        return result;

    }
}
// @lc code=end

