package 其他;
/*
 * @lc app=leetcode.cn id=1706 lang=java
 *
 * [1706] 球会落何处
 */

// @lc code=start
class Solution {
    /*
    bug free
    63/63 cases passed (2 ms)
    Your runtime beats 58.8 % of java submissions
    Your memory usage beats 45.06 % of java submissions (42.6 MB)
    */
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] result = new int[column];
        for (int i = 0; i < column; i++) {
            int x = 0;
            int y = i;
            for (int j = 0; j < row; j++) {
                y = nextP(grid, x, y);//直接模拟小球运动即可。
                x += 1;
                if (y == -1) {
                    break;
                }
                
            }
            result[i] = y;
        }
        return result;
    }

    private int nextP(int[][] grid, int x, int y) {
        int column = grid[0].length;
        int result = y;
        if (grid[x][y] == 1) {
            //右边
            if (y + 1 < column && grid[x][y+1] == 1) {
                //没到边界，并且右边方向一致
                result += 1;
            } else {
                result = -1;
            }
        } else {
            //左边
            if (y > 0 && grid[x][y - 1] == -1) {
                //没到边界，并且右边方向一致
                result -= 1;
            } else {
                result = -1;
            }
        }
        return result;
    }
}
// @lc code=end

