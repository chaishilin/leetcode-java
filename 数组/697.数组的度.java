package 数组;
import java.beans.BeanInfo;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.EtchedBorder;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        /**
         * 土方法，就一次循环统计统计谁的频率更高，谁的区间更短
         */
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> beginMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(nums[i]));
            if (beginMap.get(nums[i]) == null) {
                beginMap.put(nums[i], i);
            }
            if (endMap.get(nums[nums.length - 1 - i]) == null) {
                endMap.put(nums[nums.length - 1 - i], nums.length - 1 - i);
            }
        }
       
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == maxCount) {
                result = Math.min(result, endMap.get(nums[i]) - beginMap.get(nums[i]) + 1);
            }
        }
        return result;
    }
}
// @lc code=end
