package 数组;
/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            while (lo < hi && nums[lo] % 2 == 0) {
                lo += 1;
            }
            if (lo >= hi) {
                break;
            }
            while (lo < hi && nums[hi] % 2 == 1) {
                hi -= 1;
            }
            if(lo >= hi){
                break;
            }
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
        }
        return nums;
    }
}
// @lc code=end

