/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    private Map<Character,Integer> buildMap(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        return map;
    }
    public boolean buddyStrings(String s, String goal) {
        //这个题目是只能交换一次的
        Map<Character,Integer> mapS = buildMap(s);
        Map<Character,Integer> mapG = buildMap(goal);

        if(!mapS.equals(mapG)){
            //如果map不相同，说明两个字符串字符都不同，肯定无法交换
            return false;
        }
        int count = 0;
        for(int i  = 0; i < s.length();i++){
            if(s.charAt(i) == goal.charAt(i)){
                continue;
            }else {
                count += 1;
            }
        }
        if(count == 2){
            //如果交换次数为两次，则true
            return  true;
        }if(count == 0){
            //如果交换次数为0，但是字符串中有重复字符，也可以交换
            return mapS.size() != s.length();//如果有重复的字符，则返回true
        }else{
            return false;
        }
    }
}
// @lc code=end

