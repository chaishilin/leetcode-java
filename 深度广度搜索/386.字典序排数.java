package 深度广度搜索;
/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        dfs(result, 0, n);
        return result;
    }

    private void dfs(List<Integer> result, Integer num, Integer target) {
        if (num > 0) {//调用的时候直接存入列表，保证顺序
            result.add(num);
        }
        for (int i = 0; i < 10; i++) {
            Integer nextNum = num * 10 + i;//对于字典序
            if (nextNum <= target && nextNum > 0) {
                dfs(result, nextNum, target);//每一个数字后面可以按大小再加一个数字
            }
        }

    }
}
// @lc code=end

