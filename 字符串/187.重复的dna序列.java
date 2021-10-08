import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import java.Integer;
/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */
import java.awt.List;

// @lc code=start
class Solution {
    public int sLength = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        //状态码
        Set<String> result = new HashSet();
        Set<Long> numCount = new HashSet();
        String subString = s.substring(0, sLength);
        long num = getNum(subString);
        numCount.add(num);
        for (int i = 1; i < s.length() - sLength + 1; i++) {
            subString = s.substring(i, i + sLength);
            num = getNextNum(num, s.charAt(i + sLength - 1));
            if (numCount.contains(num)) {
                result.add(subString);
            } else {
                numCount.add(num);
            }
        }
        return new ArrayList<>(result);
    }
    public long getNum(String s) {
        //状态压缩，获得字符段的唯一标识符
        //将四个字母分别记为00，01，10，11
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += getCorrespondingNum(s.charAt(i));
            result = result * 4;
        }
        return result/4;
    }

    public long getNextNum(long num, char s) {
        num = num & ((long) Math.pow(2, sLength*2-2) - 1);
        //与操作，去掉前两位
        num *= 4;
        //后移两位
        num += getCorrespondingNum(s);
        //补充后两位
        return num;
    }

    public int getCorrespondingNum(char s) {
        int num = 0;
        if (s == 'A') {
            num += 0;
        } else if (s == 'T') {
            num += 1;
        } else if (s == 'C') {
            num += 2;
        } else if (s == 'G') {
            num += 3;
        }
        return num;
    }
}
// @lc code=end

