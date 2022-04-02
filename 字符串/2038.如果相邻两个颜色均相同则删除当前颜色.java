package 字符串;
/*
 * @lc app=leetcode.cn id=2038 lang=java
 *
 * [2038] 如果相邻两个颜色均相同则删除当前颜色
 */

// @lc code=start
class Solution {
    public boolean winnerOfGame(String colors) {
        //其实本质上就是统计AAA和BBB出现的次数，也就是字符串的匹配
        int hitA = 0, countA = 0;
        int hitB = 0, countB = 0;
        for (int i = 0; i < colors.length() && i < 3; i++) {
            if (colors.charAt(i) == 'A') {
                countA += 1;
            } else {
                countB += 1;
            }
        }
        hitA += countA == 3 ? 1 : 0;
        hitB += countB == 3 ? 1 : 0;
        for (int i = 0; i < colors.length() - 3; i++) {
            if(colors.charAt(i+3) == 'A'){
                countA += 1;
            }else{
                countB += 1;
            }
            if(colors.charAt(i) == 'A'){
                countA -= 1;
            }else{
                countB -= 1;
            }
            hitA += countA == 3 ? 1 : 0;
            hitB += countB == 3 ? 1 : 0;
        }
        return hitA > hitB;
    }
}
// @lc code=end

