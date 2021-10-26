import java.time.chrono.HijrahChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.LinkRef;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        //建立单调递减栈
        /*做法一：在pop的时候计算面积 */
        /*
        Integer result = 0;
        List<Integer> stack = new ArrayList<>();//构建递增单调栈
        int[] heights2 = new int[heights.length + 2];//在heights的前后两端都加-1，保证最后都能pop掉
        int[] areaList = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            heights2[i+1] = heights[i];
        }
        heights2[0] = -1;
        heights2[heights2.length - 1] = -1;
        int top = 0; 
        for (int i = 0; i < heights2.length; i++) {
            while (stack.size() > 0 && heights2[stack.get(stack.size() - 1)] > heights2[i]) {
                //栈本身是递增的，一个个pop的时候就是按照递减的顺序pop的
                top = stack.remove(stack.size() - 1);//因此，pop出来的height2[pop]一个比一个小
                areaList[top] = heights2[top] * (i - top);//当前坐标i减去坐标top，得到宽度，heights[top]为高度。
                //从而得到了以heights[top]开头的最大面积的矩形
                //stack中的数字最多add和pop一次，因此时间复杂度O(n)
            }
            stack.add(i);
        }
        stack = new ArrayList<>();
        for (int i = heights2.length - 1; i >= 0; i--) {
            //再反着遍历一遍，得到以heights[top]结尾的最大面积的矩形
            while (stack.size() > 0 && heights2[stack.get(stack.size() - 1)] > heights2[i]) {
                //栈本身是递增的，一个个pop的时候就是按照递减的顺序pop的
                top = stack.remove(stack.size() - 1);
                areaList[top] += heights2[top] * (top - i) - heights2[top];//减去重合部分面积
                result = Math.max(result, areaList[top]);
            }
            stack.add(i);
        }
        return result;
        */
        /*做法二：在add 的时候记录坐标 */
        //需要寻找每个柱子向左和向右的最近的小于该柱子高度的位置
        //遍历两次
        List<Integer> stack = new ArrayList<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            //需要构造单调递增的栈
            while (stack.size() != 0 && heights[stack.get(stack.size() - 1)] >= heights[i]) {
                stack.remove(stack.size() - 1);
            }
            left[i] = stack.size() == 0 ? -1 : stack.get(stack.size() - 1);
            stack.add(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            //需要构造单调递增的栈
            while (stack.size() != 0 && heights[stack.get(stack.size() - 1)] >= heights[i]) {
                stack.remove(stack.size() - 1);
            }
            right[i] = stack.size() == 0 ? heights.length : stack.get(stack.size() - 1);
            stack.add(i);
        }
        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }

}
// @lc code=end

