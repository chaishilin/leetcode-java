import javax.print.DocFlavor.STRING;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (String str : strs) {
            result = getCommon(result, str);
            System.out.println("result: "+result); 
        }
        return result;
    }
    
    public String getCommon(String str1, String str2) {
        System.out.println("compair:"+str1+"|"+str2);
        Integer index = 0;
        while (index < Math.min(str1.length(), str2.length())) {
            if (str1.charAt(index) == str2.charAt(index)) {
                index += 1;
            } else {
                break;
            }
        }
        return str1.substring(0, index);
    }
}
// @lc code=end

