package 数组;
/*
 * @lc app=leetcode.cn id=2016 lang=java
 *
 * [2016] 增量元素之间的最大差值
 */

// @lc code=start
class Solution {
    /*
    记忆化遍历一次即可
    */
    public int maximumDifference(int[] nums) {
        int res = -1;
        int minNum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            minNum = Math.min(minNum, nums[i]);
            if(nums[i + 1] - minNum > 0){
                res = Math.max(res,nums[i + 1] - minNum);
            }            
        }
        return res;
    }
}
// @lc code=end

