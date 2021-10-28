package 数学;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int count = 0;
        Map<Integer, Integer> m = new HashMap<>();
        while (n > 0) {
            int temp = n % 10;
            int nCount = m.getOrDefault(temp, 0)+1;
            n /= 10;
            m.put(temp, nCount);
            count++;
        }
        List<Map<Integer, Integer>> mList = new ArrayList<>();
        int num = 1;
        while (num < (int) Math.pow(10, count)) {//生成在输入数字附近的2的级数的map列表
            if (num >= (int) Math.pow(10, count - 1)) {
                mList.add(num2map(num));
            }
            num = num*2;
        }
        return mList.contains(m);//查看输入数字的map是否在该map列表中

    }

    public Map<Integer, Integer> num2map(int n) {
        //生成数字对应的map，比如64中有一个4和一个6
        Map<Integer, Integer> m = new HashMap<>();
        while (n > 0) {
            int temp = n % 10;
            int nCount = m.getOrDefault(temp, 0) + 1;
            n /= 10;
            m.put(temp, nCount);
        }
        return m;
    }
}
// @lc code=end

