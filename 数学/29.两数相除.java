/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int flag = 0;
        long dividendLong = dividend;
        long divisorLong = divisor;
        long divisorLongVariable = divisorLong;//二倍变长的divisor
        int count = 1;
        
        //取反的小flag
        if (dividendLong < 0) {
            dividendLong = 0 - dividendLong;
            flag += 1;
        }
        if (divisorLong < 0) {
            divisorLong = 0 - divisorLong;
            divisorLongVariable = 0 - divisorLongVariable;
            flag += 1;
        }

        //循环中每次进行减法
        while (dividendLong >= divisorLong) {
            while(dividendLong < divisorLongVariable){
                count = count >> 1;
                divisorLongVariable = divisorLongVariable >> 1;
            }
            dividendLong -= divisorLongVariable;//每次减掉的是变长减数
            result += count;//每次的商都是加上变长减数➗减数
            if (flag != 1 && result >= 2147483646) {
                return 2147483647;
            } else if (flag == 1 && result >= 2147483647) {
                return -2147483648;
            }
            count = count << 1;//每进行一次都翻倍
            divisorLongVariable = divisorLongVariable << 1;
        }
        if (flag == 1) {
            result = 0 - result;
        }
        return result;
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 8.56 % of java submissions (35.7 MB)
        */
    }
}
// @lc code=end

