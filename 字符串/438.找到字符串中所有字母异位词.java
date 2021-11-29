import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        //建立字母字典
        int[] mapP = new int[26];
        int[] mapS = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            int indexP = p.charAt(i) - 'a';
            mapP[indexP] += 1;
            int indexS = s.charAt(i) - 'a';
            mapS[indexS] += 1;
        }
        if (listEqual(mapP,mapS)) {
            result.add(0);
            //cbaebabacd
        }
        for (int j = p.length() ; j < s.length(); j++) {
            int indexStart = j - p.length();   //indexStart是要删除的头部
            mapS[s.charAt(indexStart) - 'a'] -= 1;
            mapS[s.charAt(j) - 'a'] += 1;//j是要添加的尾部
            if (listEqual(mapP,mapS)) {
                result.add(indexStart+1);//如果map相等，说明删除头部后的字符串相同，该字符串起点为indexStart+1
            }
        }
        return result;
    }

    private boolean listEqual(int[] a,int[] b) {
        for (int i = 0; i < a.length;i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

