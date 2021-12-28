package 数组.差分求区间重叠值;
/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //差分-求前缀和方法
        //对于此类求区间重叠，最大值题，都采用以上通用解法

        int[] result = new int[n];
        int[] helpList = new int[n+1];//初始化为0
        int tempSum = 0;
        for(int i = 0; i < bookings.length;i++){
            helpList[bookings[i][0]-1] += bookings[i][2];//在进入区间时，加
            helpList[bookings[i][1]] -= bookings[i][2];//在离开区间后，减
        }
        for(int i = 0 ; i < n;i++){
            tempSum += helpList[i];//求helpList数组的前缀和，即为答案
            result[i] = tempSum;
        }
        return result;
    }
}
// @lc code=end

