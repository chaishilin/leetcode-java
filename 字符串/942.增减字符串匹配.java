/*
 * @lc app=leetcode.cn id=942 lang=java
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String s) {
        int countD = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                countD += 1;
            }
        }
        int[] result = new int[s.length() + 1];
        result[0] = countD;//第一个数一定是中间的那个，这样后面才有上升和下降的空间
        int lo = countD, hi = countD;
        int count = 1;
        s = 'A' + s;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                result[count] = --lo;//下面的每个数字都是从第一个数出发，逐渐发散
            } else {
                result[count] = ++hi;
            }
            count += 1;
        }
        return result;
    }
}
// @lc code=end

