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
        // 普通dp问题，分别从左上角和右下角遍历
        buildTable(heights, leftRecord, 1);
        // woc 全世界最粗糙的解法
        reCheckTable(heights, leftRecord, 1, 1);
        reCheckTable(heights, leftRecord, 1, -1);
        reCheckTable(heights, leftRecord, -1, 1);
        reCheckTable(heights, leftRecord, -1, -1);

        int[][] rightRecord = new int[height][width];
        buildTable(heights, rightRecord, -1);
        reCheckTable(heights, rightRecord, 1, 1);
        reCheckTable(heights, rightRecord, 1, -1);
        reCheckTable(heights, rightRecord, -1, 1);
        reCheckTable(heights, rightRecord, -1, -1);
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

    private void reCheckTable(int[][] heights, int[][] record, int stepX, int stepY) {
        int height = heights.length;
        int width = heights[0].length;
        for (int i = beginIndex(height, stepX); notEnd(i, height, stepX); i += stepX) {
            for (int j = beginIndex(width, stepY); notEnd(j, width, stepY); j += stepY) {
                if (stepX == 1 && stepY == 1) {
                    // 左上开始
                    if (i - stepX >= 0 && heights[i][j] >= heights[i - stepX][j] && record[i - stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j - stepY >= 0 && heights[i][j] >= heights[i][j - stepY] && record[i][j - stepY] > 0) {
                        record[i][j] = 1;
                    } else if (i + stepX < height && heights[i][j] >= heights[i + stepX][j]
                            && record[i + stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j + stepY < width && heights[i][j] >= heights[i][j + stepY]
                            && record[i][j + stepY] > 0) {
                        record[i][j] = 1;
                    }
                } else if (stepX == 1 && stepY == -1) {
                    // 右上开始
                    if (i - stepX >= 0 && heights[i][j] >= heights[i - stepX][j] && record[i - stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j - stepY < width && heights[i][j] >= heights[i][j - stepY]
                            && record[i][j - stepY] > 0) {
                        record[i][j] = 1;
                    } else if (i + stepX < height && heights[i][j] >= heights[i + stepX][j]
                            && record[i + stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j + stepY >= 0 && heights[i][j] >= heights[i][j + stepY] && record[i][j + stepY] > 0) {
                        record[i][j] = 1;
                    }
                } else if (stepX == -1 && stepY == 1) {
                    // 左下开始
                    if (i - stepX < height && heights[i][j] >= heights[i - stepX][j] && record[i - stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j - stepY >= 0 && heights[i][j] >= heights[i][j - stepY] && record[i][j - stepY] > 0) {
                        record[i][j] = 1;
                    } else if (i + stepX >= 0 && heights[i][j] >= heights[i + stepX][j] && record[i + stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j + stepY < width && heights[i][j] >= heights[i][j + stepY]
                            && record[i][j + stepY] > 0) {
                        record[i][j] = 1;
                    }
                } else {
                    // 右下开始
                    if (i - stepX < height && heights[i][j] >= heights[i - stepX][j] && record[i - stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j - stepY < width && heights[i][j] >= heights[i][j - stepY]
                            && record[i][j - stepY] > 0) {
                        record[i][j] = 1;
                    } else if (i + stepX >= 0 && heights[i][j] >= heights[i + stepX][j] && record[i + stepX][j] > 0) {
                        record[i][j] = 1;
                    } else if (j + stepY >= 0 && heights[i][j] >= heights[i][j + stepY] && record[i][j + stepY] > 0) {
                        record[i][j] = 1;
                    }
                }
            }
        }
    }

    private void buildTable(int[][] heights, int[][] record, int step) {
        // 强行用一个函数实现了两个方向的遍历，类似迭代器模式
        int height = heights.length;
        int width = heights[0].length;
        for (int i = beginIndex(height, step); notEnd(i, height, step); i += step) {
            for (int j = beginIndex(width, step); notEnd(j, width, step); j += step) {
                if ((i == beginIndex(height, step) || j == beginIndex(width, step))) {
                    record[i][j] = 1;
                } else if (heights[i][j] >= heights[i - step][j] && record[i - step][j] > 0) {
                    record[i][j] = 1;
                } else if (heights[i][j] >= heights[i][j - step] && record[i][j - step] > 0) {
                    record[i][j] = 1;
                }
            }
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
