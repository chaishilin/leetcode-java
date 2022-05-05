/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
import java.math.BigDecimal;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[] firstLine = new int[nums.length];//把一个矩阵压缩成了两行，比较费解
        int[] secondLine = new int[nums.length];
        int[] temp = firstLine;
        int result = 0;
        int curr;
        for (int i = 0; i < nums.length; i++) {
            int countOfMax = 0;
            for (int j = i; j < nums.length; j++) {
                if (i == 0) {
                    curr = nums[j];
                } else {
                    curr = firstLine[j - 1] * nums[j];//就是类似杨辉三角
                }
                if (curr >= k || curr < 0) {
                    countOfMax += 1;
                    secondLine[j] = -1;
                } else {
                    secondLine[j] = curr;
                    result += 1;
                }
            }
            if(countOfMax >= nums.length - i){
                break;//如果有一行的乘积全部超出了规定，则再有更大的子数组的时候肯定会超规定，因此直接break
            }
            temp = firstLine;//交换指针，不是交换数组。
            firstLine = secondLine;
            secondLine = temp;
        }
        return result;
    }
}
// @lc code=end

