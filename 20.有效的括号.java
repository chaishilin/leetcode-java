

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        for(int j = 0 ; j < s.length();j+=1){
            Character i = s.charAt(j);
            if(i == ']' && stack.size() > 0 && stack.get(stack.size()-1) == '['){
                stack.remove(stack.size()-1);
            }else if(i == '}' && stack.size() > 0 && stack.get(stack.size()-1) == '{'){
                stack.remove(stack.size()-1);
            }else if(i == ')' && stack.size()> 0 && stack.get(stack.size()-1) == '('){
                stack.remove(stack.size()-1);
            }else {
                stack.add(i);
            }
        }
        return stack.size() == 0;
        

    }
}
// @lc code=end

