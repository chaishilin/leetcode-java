/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area) / 1;
        while (l <= area) {
            if (area % l == 0) {
                int w = area / l;
                if (l >= w) {
                    return new int[] { l, w };
                }
            }
            l += 1;

        }
        return new int[] { area, 1 };
        


    }
}
// @lc code=end

