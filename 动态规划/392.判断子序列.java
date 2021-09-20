import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;

/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        //方法一：双指针思路，看sl有没有走到最后
        /*
        int sl = s.length();
        int tl = t.length();
        int i = 0, j = 0;
        while (i < sl && j < tl) {
            if (s.charAt(sl) == t.charAt(tl)) {
                sl += 1;
            }
            tl += 1;
        }
        return i == sl;
        */


        //方法二：动态规划
        //对于两个数字，首先要构造一个二维的dp表,
        //表格记录了待对比的t串中每个字符后最先出现（包含该字符位置）的每个字母的下标位置
        int sl = s.length();
        int tl = t.length();
        int[][] f = new int[tl + 1][26]; //多加了一行作为t的边界
        for (int i = 0; i < 26; i++) {
            f[tl][i] = -1;//边界值为-1
        }

        //填入表格内容，倒着填
        for (int j = tl - 1; j >= 0; j--) {
            for (int i = 0; i < 26; i++) {
                if (t.charAt(j) == i + 'a') {
                    //如果t的j处恰好为该字母
                    //则记录t字符串的下标j
                    f[j][i] = j;
                } else {
                    //如果不是该字母，则看下t的j+1处有没有匹配上
                    f[j][i] = f[j + 1][i];
                }
            }
        }

        //根据s进行查表
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (f[tIndex][s.charAt(i) - 'a'] == -1) {
                //如果t字符串中的tIndex处后，没有s[i]字符了
                //那么就匹配失败
                return false;
            }else{
                //否则就是匹配到s[i]字符了，查到的位置为表格中的数字。继续查找下一个字符
                //查找的位置是t字符串中匹配到的s[i]字符的下一个位置开始。下一个循环中，i会加一
                tIndex = f[tIndex][s.charAt(i) - 'a'] + 1;
            }
        }
        return true;



    }
    
}
// @lc code=end

