import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        //这个题有点投机取巧
        StringBuilder result = new StringBuilder();
        int[] mapS = word2Map(s);
        int[] countList = new int[10];
        countList[2] = mapS['w'-'a'];
        countList[6] = mapS['x'-'a'];
        countList[0] = mapS['z'-'a'];
        countList[4] = mapS['u'-'a'];
        countList[8] = mapS['g'-'a'];

        countList[3] = mapS['h'-'a'] - countList[8];
        countList[5] = mapS['f'-'a'] - countList[4];
        countList[7] = mapS['v'-'a'] - countList[5];

        countList[1] = mapS['o'-'a'] - countList[0] - countList[2] - countList[4];
        countList[9] = mapS['i'-'a'] - countList[5] - countList[6] - countList[8];

        for(int index = 0 ; index< 10;index++){
            for(int i = 0;i  < countList[index];i++){
                result.append(index);
            }
        }
        return result.toString();

    }
    private int[] word2Map(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] += 1;
        }
        return map;
    }
}
// @lc code=end

