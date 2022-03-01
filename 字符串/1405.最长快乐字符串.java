package 字符串;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1405 lang=java
 *
 * [1405] 最长快乐字符串
 */

// @lc code=start
class Solution {
    /*
    贪心算法,abc三个字符中，先选出满足要求的，存量最多的那个字符。
    */
    public String longestDiverseString(int a, int b, int c) {
  
        StringBuffer sb = new StringBuffer();
        while (true) {
            String tail = null;
            if (sb.length() > 2) {
                tail = sb.substring(sb.length() - 2, sb.length());
            } else {
                tail = sb.toString();
            }            
            Character character = choose(a, b, c,tail);
            if (character == 'a') {
                a -= 1;
            }else if(character == 'b'){
                b -= 1;
            }else if(character == 'c'){
                c -= 1;
            }else{
                break;
            }
            sb.append(character);
        }
        return sb.toString();
    }

    private Character choose(int a,int b,int c,String tail){
        if (a >= b && a >= c){
            if (a > 0 && !"aa".equals(tail)) {
                return 'a';
            } else if (b >= c && b > 0 && !"bb".equals(tail)) {
                return 'b';
            } else if (c > 0  && !"cc".equals(tail)) {
                return 'c';
            }
        } else if (b >= a && b >= c) {
            if (b > 0 && !"bb".equals(tail)) {
                return 'b';
            } else if (a >= c && a > 0 && !"aa".equals(tail)) {
                return 'a';
            } else if (c > 0  && !"cc".equals(tail)) {
                return 'c';
            }
        } else if (c >= b && c >= a) {
            if (c > 0 && !"cc".equals(tail)) {
                return 'c';
            } else if (a >= b && a > 0 && !"aa".equals(tail)) {
                return 'a';
            } else if (b > 0 && !"bb".equals(tail)) {
                return 'b';
            }
        }
        return '-';
    }

    
}
// @lc code=end

