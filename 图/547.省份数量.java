package 图;
/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

import java.util.zip.Inflater;

// @lc code=start
class Solution {
    /*
    图的深度递归搜索
    Your runtime beats 89.7 % of java submissions
    Your memory usage beats 22.7 % of java submissions (42.1 MB)
    */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int[] visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                //只访问没访问过的
                mark(visited, isConnected, i);
                res += 1;
            } 
        }
        return res;
    }

    private void mark(int[] visited, int[][] isConnected, int i) {
        visited[i] = 1;//当前这个节点肯定访问了
        for (int index = 0; index < isConnected.length; index++) {
            if (isConnected[i][index] == 1) {//如果能访问
                if (visited[index] == 0) {//如果没访问过
                    visited[index] = 1;//访问它！
                    mark(visited, isConnected, index);
                }                
            }
        }
    }
}
// @lc code=end

