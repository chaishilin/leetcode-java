package 动态规划;
/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {
        int count = 0;
        int result = 0;
        boolean meet1 = false;
        while (n != 0) {
            int temp = n & 1;//取二进制的最后一位
            if(temp == 0 && meet1){
                count += 1;
            }else if(temp == 1){
                meet1 = true;
                result = Math.max(result,count);//统计1和1之间的count
                count = 1;
            }
            n >>= 1;
        }
        return result;
    }
}
// @lc code=end

