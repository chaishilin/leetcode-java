/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        /**
         * 倒着二维dp，从后往前匹配，mat[i][j]储存的是已匹配的长度
         */
        int[][] mat = new int[nums1.length + 1][nums2.length + 1];//+1是为了当哨兵
        int result = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    mat[i][j] = mat[i + 1][j + 1] + 1;
                    result = Math.max(result, mat[i][j]);
                }
            }
        }
        return result;
    }
}
// @lc code=end
