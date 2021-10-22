/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        //不偷懒的解法
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += flag;
            if (digits[i] == 10) {
                digits[i] = 0;
                flag = 1;
            } else {
                flag = 0;
            }
            //如果不是第一个数字，并且也不进位，那么可以退出循环
            if (i != digits.length - 1 && flag == 0) {
                break;
            }
        }
        if (flag == 1) {
            //如果多了一位，则需要拷贝数组
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                result[j + 1] = digits[j];
            }
            return result;
        } else {
            return digits;
        }

        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 39.11 % of java submissions (36.9 MB)
        */
        

    }
}
// @lc code=end

