/*
 * @lc app=leetcode.cn id=1893 lang=java
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] helpList = new int[52];//题目给的区间很小，没必要计较空间时间
        for(int i = 0; i < ranges.length; i++){
            helpList[ranges[i][0]] += 1;
            helpList[ranges[i][1]+1] -= 1;
        }
        int tempSum = 0;
        for(int i = 0; i <= right ;i++){
            tempSum += helpList[i];
            if(i >= left && tempSum == 0){
                //进入判断区间后，开始判断是否总和还是0
                return false;
            } 
        }
        return true;
    }
}
// @lc code=end

