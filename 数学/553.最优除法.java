package 数学;
/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    /*
    其实就是a/(b/c/d/e/f),分母全都包起来即可
    */
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(nums[0]);
            sb.append("/(");
            for (int i = 1; i < nums.length; i++) {
                sb.append(nums[i]);
                sb.append("/");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            return sb.toString();
        }
    }
}
// @lc code=end

