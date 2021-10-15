import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String result = "";
        String resultPre = countAndSay(n - 1);
        resultPre += "a";//哨兵字符，这样的话result就会完整处理完'a'之前的所有字符
        int count = 0; 
        for (int i = 0; i < resultPre.length(); i++) {
            if (i == 0 ||(resultPre.charAt(i) == resultPre.charAt(i - 1))) {
                count++;
            } else {
                result = result + "" + count;
                result = result + "" + resultPre.charAt(i - 1);
                count = 1;
            } 
        }
        return result;
    }
}
// @lc code=end

