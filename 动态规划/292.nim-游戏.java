package 动态规划;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        /*
        //动态规划的思路
        if (n <= 3) {
            return true;
        }
        //n=1,2,3时，都会胜利
        boolean d1 = true;
        boolean d2 = true;
        boolean d3 = true;
        for(int i = 3;i<n;i++){
            boolean result;
            result = !(d1 == d2 && d1 == d3);
            //进行下一局时，如果对方在n-3、n-2、n-1的情况下都会出现相同的结果（这个游戏显然可能会连胜而不是连败），那么自己这边肯定会输
            d1 = d2;
            d2 = d3;
            d3 = result;
        }
        return d3;
        //就这算法还被嫌弃超时
        */


        //通过总结规律发现，四个为一组循环
        return n%4!=0;
    }
}
// @lc code=end

