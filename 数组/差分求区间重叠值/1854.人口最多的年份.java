package 数组.差分求区间重叠值;
/*
 * @lc app=leetcode.cn id=1854 lang=java
 *
 * [1854] 人口最多的年份
 */

// @lc code=start
class Solution {
    public int maximumPopulation(int[][] logs) {
        int minNum = 10000;
        int maxNum = 0;
        for(int i = 0 ; i < logs.length; i++){
            minNum = Math.min(minNum,logs[i][0]);
            maxNum = Math.max(maxNum,logs[i][1]);
        }
        int[] helpList = new int[maxNum - minNum + 1];
        for(int i = 0 ; i < logs.length; i++){
            helpList[logs[i][0]-minNum] += 1;
            helpList[logs[i][1]-minNum] -= 1;
        }
        int tempSum = 0;
        int result = 0;
        int bigSum = 0;
        for(int i = 0 ; i < helpList.length;i++){
            tempSum += helpList[i];
            if(bigSum < tempSum){//当前最大人数有更新的时候直接记录下年份即可
                result = i + minNum;
                bigSum = tempSum;
            }
        }
        return result;
        //bug free 一次通过！
    }
}
// @lc code=end

