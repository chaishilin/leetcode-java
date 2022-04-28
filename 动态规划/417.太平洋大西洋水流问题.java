/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int height = heights.length;
        int width = heights[0].length;
        int[][] leftRecord = new int[height][width];
        buildTable(heights,leftRecord,1);//修改成dfs，比较快了一点，代码也比较简洁
        int[][] rightRecord = new int[height][width];
        buildTable(heights,rightRecord,-1);
        return countTable(leftRecord, rightRecord);

    }

    private List<List<Integer>> countTable(int[][] leftRecord, int[][] rightRecord) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < leftRecord.length; i++) {
            for (int j = 0; j < leftRecord[0].length; j++) {
                if (leftRecord[i][j] + rightRecord[i][j] == 2) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }
        return result;
    }

    private void buildTable(int[][] heights, int[][] record, int step) {
        //强行用一个函数实现了两个方向的遍历，类似迭代器模式
        int height = heights.length;
        int width = heights[0].length;
        for (int i = beginIndex(height, step); notEnd(i, height, step); i += step) {
            for (int j = beginIndex(width, step); notEnd(j, width, step); j += step) {
                if ((i == beginIndex(height, step) || j == beginIndex(width, step))) {
                    if (record[i][j] == 0) {
                        dfs(heights, record, i, j, step);
                    }
                }
            }
        }
    }

    private void dfs(int[][] heights, int[][] record, int i, int j, int step) {
        int height = heights.length;
        int width = heights[0].length;
        record[i][j] = 1;
        if (notEnd(i + step, height, step) && record[i + step][j] == 0 && heights[i + step][j] >= heights[i][j]) {
            dfs(heights, record, i + step, j, step);
        }
        if (notEnd(j + step, width, step) && record[i][j + step] == 0 && heights[i][j + step] >= heights[i][j]) {
            dfs(heights, record, i, j + step, step);
        }
        if (notEnd(i - step, height, -step) && record[i - step][j] == 0 && heights[i - step][j] >= heights[i][j]) {
            dfs(heights, record, i - step, j, step);
        }
        if (notEnd(j - step, width, -step) && record[i][j - step] == 0 && heights[i][j - step] >= heights[i][j]) {
            dfs(heights, record, i, j - step, step);
        }
    }

    private int beginIndex(int length, int step) {
        if (step > 0) {
            return 0;
        } else {
            return length - 1;
        }
    }

    private boolean notEnd(int index, int length, int step) {
        if (step > 0) {
            return index != length;
        } else {
            return index != -1;
        }
    }
}
// @lc code=end
