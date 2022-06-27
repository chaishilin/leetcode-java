/*
 * @lc app=leetcode.cn id=522 lang=java
 *
 * [522] 最长特殊序列 II
 */

// @lc code=start
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean check = true;
            for (int j = 0; j < strs.length; j++) {
                //对于每一个strs[i]，如果它是某个字符串的子序列
                if (i != j && isSub(strs[i], strs[j])) {
                    check = false;//那它就不是特殊子序列
                    break;
                }
            }
            if (check) {//对于是特殊子序列的,拿到最大的长度
                System.out.println(strs[i]);
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    private boolean isSub(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return i == a.length();
    }
}
// @lc code=end

