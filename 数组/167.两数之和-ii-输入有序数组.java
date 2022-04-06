package 数组;
/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    //双指针往中间走，时间复杂度on，空间o1
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] < target) {
                lo += 1;
            } else if (numbers[lo] + numbers[hi] > target) {
                hi -= 1;
            }else{
                result[0] = lo + 1;
                result[1] = hi + 1;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

