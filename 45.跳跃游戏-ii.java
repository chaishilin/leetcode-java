/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        //solution 1 时间复杂度on2
        /*
        int[] score = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            int temp = i;
            for (int j = 0; j < i; j++) {
                if(i-j <= nums[j]){
                    temp = Math.min(temp,1+score[j]);
                }
            }
            score[i] = temp;
        }
        return score[nums.length - 1];
        */
        
        //solution 2 时间复杂度on
        //贪心算法， 好巧妙啊
        int count = 0;
        int end = 0;//记录每个阶段的最远距离
        int maxPosition = 0;
        for(int i = 0 ; i < nums.length -1 ;i++){
            maxPosition = Math.max(maxPosition,nums[i]+i);//不断更新最远距离
            if (i == end) {//当遍历到这一步走完时，
                //相当于走到end的时候，下一步已经最远能到maxPosition了
                end = maxPosition;//下一步最远距离就是maxPosition那么远
                count += 1;//算是走了一步了
            }
        }
        return count;
    }
}
// @lc code=end

