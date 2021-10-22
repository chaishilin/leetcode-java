import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //空间复杂度为n的
        /*
        Map<Integer, Integer> m = new HashMap<>();
        Set<Integer> result = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            if (m.get(nums[i]) > nums.length / 3) {
                result.add(nums[i]);
            }
        }
        return new ArrayList<>(result);
        */
        //空间复杂度为1的
        //摩尔投票法
        int result1 = 0;
        int result2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (count1 > 0 && num == result1) {
                count1 += 1;
            } else if (count2 > 0 && num == result2) {
                count2 += 1;
            } else if (count1 == 0) {//如果第一个元素抵消没了
                result1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                result2 = num;
                count2 = 1;
            } else {
                //如果两个都不匹配
                count1 -= 1;
                count2 -= 1;
            }
        }
        
        int c1 = 0;
        int c2 = 0;
        for (int num : nums) {
            if (count1 > 0 && result1 == num) {
                //如果result1是投票投出来的（count1>0）
                c1++;
            } 
            if (count2> 0 &&result2 == num) {
                c2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > 0 && c1 > nums.length / 3) {
            result.add(result1);
        }
        if (count2 > 0 && c2 > nums.length / 3) {
            result.add(result2);
        }
        return result;

    }
    
    
}
// @lc code=end

