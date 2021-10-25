package 数组;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        int x = 0;//行数
        int y = n-1;//列数
        //从矩阵的右上角开始，
        //如果[x,y]小于target，那么当前[x,y]所在的行，不可能出现大于target的数字,因此x+1
        //如果[x,y]大于target，当前所在列，不可能出现比target更小的数字，y-1
        while (x <= m - 1 && y >= 0) {
            if(matrix[x][y] == target){
                return true;
            }
            if(target < matrix[x][y]){
                y--;
            }else if (target > matrix[x][y]) {
                x++;
            }
        }
        return false;
    }

}
// @lc code=end

