/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for(int[] items : accounts){
            result = Math.max(result,sumNum(items));
        }
        return result;
    }

    public int sumNum(int[] nums){
        int result = 0;
        for(int num:nums ){
            result+= num;
        }
        return result;
    }
}
// @lc code=end

