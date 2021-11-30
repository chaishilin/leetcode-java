package 数学;
/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        //找规律：前9个数字是1位的，前10~99个数字是2位的，以此类推
        //9*1+90*2+900*3+9000*4
        //0,10,100
        int i = 0;
        long count = 0;//前i位数字的总长度,还要防止溢出，用long
        while (true) {
            long temp = 9 * (long) Math.pow(10, i) * (i + 1);
            if (count + temp >= n) {
                //对于n为9等边界情况，依然跳出循环
                break;
            } else {
                count += temp;
                i += 1;
            }
        }
        
        long numCount = n - count;//第n个数字为 i位数字中的第numCount个
        long startNum = (int)Math.pow(10, i) - 1;//i位数的第一个的前一个
        long targetNum = startNum + (int) Math.ceil((double) numCount / (double) (i + 1));//在startNum的基础上，往后数N个，N要向上取整
        //Math.ceil(数字一定要用double)
        int targetPosition =(int) (numCount - 1) % (i + 1);//最终答案是targetNum中的第targetPosition个数字
        long result = 0;
        while (targetPosition <= i) {//通过对mod10循环，获得答案
            result = targetNum % 10;
            targetNum = targetNum / 10;
            targetPosition += 1;
        }
        return (int)result;
    }
}
// @lc code=end

