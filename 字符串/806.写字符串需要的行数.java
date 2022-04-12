package 字符串;
/*
 * @lc app=leetcode.cn id=806 lang=java
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int width = 0;
        int line = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int need = widths[c - 'a'];
            width += need;
            if(width > 100){
                line += 1;//超了100就放在下一行，
                width = need;//放在下一行了
            }
        }
        return new int[]{line,width};
    }
}
// @lc code=end

