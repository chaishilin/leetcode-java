import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        //方法一：遍历
        //题解也是在遍历
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i += 1) {
            if (i == 0) {
                result.add(0);
            } else if (i == 1) {
                result.add(1);
            } else if (i % 2 == 0) {
                result.add(result.get(i / 2));
            } else {
                result.add(result.get(i / 2) + result.get(i / 2 + 1));
            }
        }
        System.out.println(result);

        return Collections.max(result);    

    }
}
// @lc code=end

