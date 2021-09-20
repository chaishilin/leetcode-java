import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
class Solution {
    //加一个字典，帮助递归记忆
    public Map<Integer,Boolean> resultMap = new HashMap<>();  

    public boolean divisorGame(int n) {
        if (resultMap.get(n) != null) {
            return resultMap.get(n);
        }
        if (n == 1 || n == 3) {
            resultMap.put(n, false);
            return false;
        }
        if (n == 2) {
            resultMap.put(n, true);
            return true;
        }
        boolean result = false;
        for (int i = 1; i < n; i += 1) {
            //对于每个数字，看看该数字下能否获胜？
            if (n % i == 0) {
                //注意“！”，因为自己出数字后就要对方出数字了，对方赢了就是自己输了
                result = result || !(divisorGame(n - i));
            }
        }
        resultMap.put(n, result);
        return result;
    }
}
// @lc code=end

