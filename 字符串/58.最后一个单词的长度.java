import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int flag = 0;//当前是否在最后一个单词
        for (int j = s.length() - 1; j >= 0; j -= 1) {
            //从后向前遍历
            if (s.charAt(j) != ' ') {
                if (flag == 1) {
                    //如果在最后一个单词
                    count += 1;
                } else if (count == 0 && flag == 0) {
                    //如果还没开始计数，但是遇到了字符
                    flag = 1;
                    count += 1;                    
                } 
            } else {
                if (flag == 0) {
                    //如果倒着数还是空格，并且还没到最后一个单词
                    continue;
                } else {
                    //数过了第一个字符
                    break;
                }
            }
        }
        return count;

    }
}
// @lc code=end

