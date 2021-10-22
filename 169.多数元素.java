/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != result) {
                count -= 1;
            } else {
                count += 1;
            }
            if (count == 0) {
                count = 1;
                result = nums[i];
            }
        }
        return result;
    }
}
// @lc code=end

