package 数组;
/*
 * @lc app=leetcode.cn id=2006 lang=java
 *
 * [2006] 差的绝对值为 K 的数对数目
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// @lc code=start
class Solution {
    /*
    把数组去重，计算res的时候，把各个数字出现的次数相乘即可
    */
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0)+1);
        }
        for (Integer i:numSet) {
            for (Integer j:numSet) {
                if (j - i == k) {
                    res += numMap.get(i)*numMap.get(j);
                }
            }
        }
        return res;
    }
}
// @lc code=end

