package 字符串;
/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

import java.awt.List;
import java.util.ArrayList;

import javax.crypto.Cipher;

// @lc code=start
class Solution {
    /*
    原来一般的做法是前后双指针，只交换字母。。。
    bug free
    Your runtime beats 6.28 % of java submissions
    Your memory usage beats 5.17 % of java submissions (40 MB)
    */
    public String reverseOnlyLetters(String s) {
        List<Character> cstack = new ArrayList<>();//一个当成栈
        List<Character> nqueue = new ArrayList<>();//一个当成队列
        List<Integer> nums = new ArrayList<>();//记录每个间隔的长度
        int num = 0;
        String preType = "c";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (preType.equals("n")) {
                    nums.add(num);
                    num = 0;
                }
                cstack.add(c);
                preType = "c";
            } else {
                if (preType.equals("c")) {
                    nums.add(num);
                    num = 0;
                }
                nqueue.add(c);
                preType = "n";
            }
            num += 1;
        }
        nums.add(num);
        return readS(cstack,nqueue,nums);//根据以上信息将其还原

    }

    private String readS(List<Character> cstack, List<Character> nqueue, List<Integer> nums) {
        StringBuilder result = new StringBuilder();
        int cIndex = cstack.size();
        int nIndex = 0;
        int change = 0;
        for (Integer num : nums) {
            if (change % 2 == 0) {
                //字母
                for (int i = 0; i < num; i++) {
                    result.append(cstack.get(cIndex - 1));
                    cIndex -= 1;
                }
            } else {
                //其他
                for (int i = 0; i < num; i++) {
                    result.append(nqueue.get(nIndex));
                    nIndex += 1;
                }
            }
            change += 1;
        }
        return result.toString();
    }
}
// @lc code=end

