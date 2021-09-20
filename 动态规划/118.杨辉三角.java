import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> tempPre = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        //动态规划的思路
        
        for (int i = 0; i < numRows; i += 1) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j += 1) {
                //每一层都是上一层生成的
                if (i == 0 || j == 0 || j == i)
                    temp.add(1);//如果这一层是边界，则是1
                else {
                    //否则，当前值与上一层对应下标的值有关
                    temp.add(tempPre.get(j - 1) + tempPre.get(j));
                }
            }
            result.add(temp);//这一层加入结果
            tempPre = temp;//为下一层做准备
        }
        return result;
    }
}
// @lc code=end

