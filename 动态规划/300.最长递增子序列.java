import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp一维数组，dp[i]记录的是以i结尾的最长子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                if (nums[j] < nums[i]) {
                    //如果当前数字大于前面的某个数字
                    //则可以看看当前数字接上前面那个数字后的子序列长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxNum = 0;
        for (int p : dp) {
            maxNum = Math.max(maxNum, p);
        }
        return maxNum;

    }
}
// @lc code=end

