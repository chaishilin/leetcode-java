/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {

    private Map<Integer, List<Integer>> numMap = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> nList = numMap.getOrDefault(nums[i], new ArrayList<>());
            nList.add(i);
            numMap.put(nums[i], nList);
        }
    }

    public int pick(int target) {
        List<Integer> nList = numMap.get(target);
        Random random = new Random();
        return nList.get(random.nextInt(nList.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

