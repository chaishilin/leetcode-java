/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int result = 1;
        int count = 0;
        int[] visited = new int[nums.length];//用一个数组进行标记当前元素是否访问过
        for (int num : nums) {
            if (visited[num] == 0) {
                count = 0;
                int key = num;
                while (visited[key] == 0) {//按照下标往下查找
                    visited[key] = 1;
                    key = nums[key];
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
// @lc code=end
