import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        //java 字符串的下标是从左往右,与python的逻辑相反
        Integer result =  map.get(s.charAt(0));
        for (Integer i = 1; i < s.length(); i += 1) {
            Integer indexValue = map.get(s.charAt(i));
            Integer oldIndexValue = map.get(s.charAt(i-1));
            if (indexValue <= oldIndexValue) {
                //如果右边的比左边的小，说明是正常现象
                result += map.get(s.charAt(i));
            } else {
                //如果遇到4和9的情况，需要把前面下标代表的数字减去两边（因为上次循环中多加了）
                result += map.get(s.charAt(i));
                result -= map.get(s.charAt(i - 1));
                result -= map.get(s.charAt(i-1));
            }  
        }
        return result;
    }
}
// @lc code=end

