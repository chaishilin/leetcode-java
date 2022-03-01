package 图;
/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

import java.awt.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

import javax.crypto.Cipher;
import javax.print.event.PrintJobAttributeEvent;

import org.w3c.dom.css.CSS2Properties;

// @lc code=start
class Solution {
    /*
    单源最短路径算法 Dijkstra
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] mat = buildMat(times, n);
        int[] distance = new int[n];//从k到其他节点的距离
        boolean[] used = new boolean[n];//节点是否已经获得了最短距离
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(used,false);
        distance[k-1] = 0;//自己到自己的距离是0
        for(int i = 0; i < n;i++){
            int x = -1;
            for(int j = 0;j < n; j++){
                if(!used[j] && (x == -1 || distance[x] > distance[j])){
                    x = j;//先选择到k最近的这个节点
                }
            }
            used[x] = true;//该节点标记为已使用
            for(int y = 0; y < n; y++){
                distance[y] = Math.min(distance[y],distance[x]+mat[x][y]);
            }
        }
        int result = Arrays.stream(distance).max().getAsInt();
        return result == Integer.MAX_VALUE/2 ? -1 : result;
    }
    private int[][] buildMat(int[][] times, int n) {
        int[][] mat = new int[n][n];
        final int inf = Integer.MAX_VALUE/2;
        for(int i = 0; i < n; i++){
            Arrays.fill(mat[i],inf);
        }
        for (int[] time : times) {
            mat[time[0] - 1][time[1] - 1] = time[2];
        }
        return mat;
    }    
}
// @lc code=end

