import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i += 1) {
            result = new ArrayList<>();
            for (int j = 0; j <= i; j += 1) {
                if (j == 0 || j == i) {
                    result.add(1);
                } else {
                    //与第118题同理，注意不要写错了边界
                    result.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = result;
        }
        return result;

    }
}
// @lc code=end

