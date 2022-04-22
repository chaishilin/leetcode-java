package 数学;
/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int tempResult = 0;
        int numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            tempResult += nums[i] * i;
        }
        int result = tempResult;
        for (int i = nums.length - 1; i > 0; i--) {
            tempResult += numSum - nums.length * nums[i];//f(n)和f(n-1)有公式的。。。
            result = Math.max(result, tempResult);
        }
        return result;
    }
}
// @lc code=end

