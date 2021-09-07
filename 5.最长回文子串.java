/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        //1、中心扩散法 比较好理解
        char[] charS = s.toCharArray();
        int starter = 0;
        int ender = 0;
        int maxNum = 0;
        for (int i = 0; i < charS.length; i += 1) {
            
            int l1 = lengthFromCenter(charS, i, i);
            int l2 = lengthFromCenter(charS, i, i + 1);
            int len = Math.max(l1, l2);
            
            if (len > maxNum) {
                starter = i - (len - 1) / 2 ;  //根据返回的子串的长度，确定下标开头和结尾
                ender = i + len / 2 ;
                maxNum = len;
            }
        }
        return s.substring(starter, ender + 1);
    }
    
    public int lengthFromCenter(char[] s, int lo, int hi) {
        while (lo >= 0 && hi < s.length && s[lo] == s[hi]) {
            lo -= 1;
            hi += 1;
        }
        return hi - lo - 2 + 1;
    }
    
    public String method2(String s){
        //2、动态规划 二维dp表格
        //dp表格中dp[i][j]代表了从i到j的子串是不是回文的
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;//只有一个字母的话本身当然是回文的
        }
        int maxNum = 0;
        int starter = 0;
        int ender = 0;
        //dp[i][j] = dp[i+1][j-1]  (i,j)是否回文取决于(i+1,j-1)是否回文，并且char[i] == char[j]
        for (int i = s.length() - 1; i >= 0; i--) {
            //因为i取决于i+1，因此从大往小循环
            for (int j = i + 1; j < s.length(); j++) {
                //j大于i，且从小往大循环
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        //如果j+1后还大于了i-1，说明i、j是相邻的，只需要判断s[i] = s[j]
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] == 1 && j - i + 1 > maxNum) {
                        starter = i;
                        ender = j;
                        maxNum = j - i + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s.substring(starter, ender+1);
    }
    
}
// @lc code=end

