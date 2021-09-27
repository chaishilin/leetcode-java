/*
 * @lc app=leetcode.cn id=639 lang=java
 *
 * [639] 解码方法 II
 */
// @lc code=start
class Solution {
    public Map<Integer,Long> dMap = new HashMap<>();

    public int numDecodings(String s) {
        //对于每个数字，有两种可能，要一位和要两位
        //result 是 乘法 加法的关系
        long answer = help(s, 0);
        return (int)(answer%(1000000000+7));
    }
    
    public long d2Method(int index,String s){
        long k = 1;
        if (s.charAt(index) == '*') {
            //第一位数字是星号
            if (s.charAt(index + 1) == '*') {
                //第二位数字是星号
                k *= 15; //十位数有两种情况，个位数有九种情况 "**"在一起是有15个表示方法
            } else if (s.charAt(index + 1) <= '6') {
                //16，26 两种情况，17，18只有一种情况
                k *= 2;
            }
        } else if (s.charAt(index) == '0') {
            k *= 0;//第一位不能是0
        } else {
            //第一位是数字
            if (s.charAt(index + 1) == '*') {
                //第二位数字是星号
                if (s.charAt(index) == '1') {
                    k *= 9;
                } else if (s.charAt(index) == '2') {
                    k *= 6;
                } else {
                    k *= 0;//第一位数字大于2的话，无法组成编号，因为编号要小于26
                }
            } else if (s.charAt(index + 1) <= '6') {
                //第二位数字小于等于6
                if (s.charAt(index) <= '2') {
                    //第一位数字小于等于2
                    k *= 1;
                } else {
                    k *= 0;//第一位数字大于2的话，无法组成编号，因为编号要小于26
                }
            } else {
                //第二位数字大于6
                if (s.charAt(index) == '1') {
                    k *= 1;
                } else {
                    k *= 0;
                }
            }
        }
        return k;
    }
    public long d1Method(int index,String s){
        int k1 = 1;
        if (s.charAt(index) == '*') {
            k1 = 9;//字符为星时，有九种可能，其他情况下有一种可能
        } else if (s.charAt(index) == '0') {
            k1 = 0;//为0的时候，不能单独组成一个编码，不能这么分
        }
        return k1;
    }
    public long help(String s, int index) {
        if (s.length() <= index ) {
            return 1;
        }
        long result = 0;
        long k1 ;//index + 1时,只要一个字符
        long k2 ;

        if(dMap.containsKey(index)){
            return dMap.get(index);
        }
        k1 = d1Method(index,s);
        result = k1 * help(s, index + 1);
        result = result % (1000000000 + 7);
        if (s.length() > index + 1) {
            k2 = d2Method(index,s);
            result += k2 * help(s, index + 2);
            result = result % (1000000000 + 7);
        }
        dMap.put(index,result);
        return result;
    }
}
// @lc code=end

