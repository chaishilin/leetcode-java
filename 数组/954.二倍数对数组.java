/*
 * @lc app=leetcode.cn id=954 lang=java
 *
 * [954] 二倍数对数组
 */

// @lc code=start
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        boolean result = true;
        List<Integer> opNum = new ArrayList<>();
        List<Integer> ngNum = new ArrayList<>();
        for (int a : arr) {
            if (a >= 0) {
                opNum.add(a);
            } else {
                ngNum.add(-a);
            }
        }
        opNum.sort(Integer::compare);
        ngNum.sort(Integer::compare);
        return ok(opNum) && ok(ngNum);
    }

    private boolean ok(List<Integer> nums) {
        if (nums.size() % 2 == 1) {
            return false;
        }
        Map<Integer, Integer> countM = new HashMap<>();//关键在于做hashmap，记录每个数字出现次数
        nums.forEach(item -> countM.put(item, countM.getOrDefault(item, 0) + 1));
        //从小到大遍历，对于小的数字num和次数count，应该有数字num*2，且出现次数大于count
        //不满足该条件，则返回false
        for (Integer num : nums) {
            Integer count = countM.get(num);
            Integer twoCount = countM.getOrDefault(num * 2, 0);
            if (twoCount >= count) {
                countM.put(num, 0);
                countM.put(num * 2, twoCount - count);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

