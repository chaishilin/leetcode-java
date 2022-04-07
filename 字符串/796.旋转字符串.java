package 字符串;
/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        /*
            Your runtime beats 100 % of java submissions
            Your memory usage beats 74.41 % of java submissions (38.9 MB)
        */
        //当然也可以return (s + s).contains(goal);
        if (s.length() != goal.length()) {
            return false;
        }
        for(int start :findIndexs(s.charAt(0),goal)){
            int right = start;
            boolean ok = true;
            for(int left = 0; left < s.length();left++){
                if(s.charAt(left) != goal.charAt(right)){
                    ok = false;
                    break;
                }
                right = (right+1)%s.length();
            }
            if(ok){
                return true;
            }
        }
        return false;

    }

    private List<Integer> findIndexs(char c, String goal) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < goal.length(); i++) {
            if(goal.charAt(i) == c){
                result.add(i);
            }
        }
        return result;
    }
}
// @lc code=end

