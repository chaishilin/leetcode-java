/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //将重叠区域投影在X轴和Y轴，可以发现该区域的长和宽即为两个矩形长和宽的重叠部分。
        int coverLong = Math.max(0,Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int coverHeight = Math.max(0,Math.min(ay2, by2) - Math.max(ay1, by1));
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - coverHeight * coverLong;

    }
}
// @lc code=end

