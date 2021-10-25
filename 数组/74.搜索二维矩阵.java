/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 91.63 % of java submissions (37.6 MB)
        */
        //矩阵展开就是个排序数组，对其进行二分查找即可
        return binarySearch(matrix, target, 0, matrix.length * matrix[0].length);
    }

    public boolean binarySearch(int[][] matrix, int target, int lo, int hi) {
        if (lo + 1 >= hi) {
            int[] midLo = index2m(lo, matrix[0].length);
            int matrixAtLo = matrix[midLo[0]][midLo[1]];
            int[] midHi = index2m(lo, matrix[0].length);
            int matrixAtHi = matrix[midHi[0]][midHi[1]];
            if (matrixAtLo == target || matrixAtHi == target) {
                return true;
            } else {
                return false;
            }
        }
        int mid = (lo + hi) / 2;
        int[] midIndex = index2m(mid, matrix[0].length);
        int matrixAtIndex = matrix[midIndex[0]][midIndex[1]];
        if (matrixAtIndex == target) {
            return true;
        }
        if (matrixAtIndex < target) {
            return binarySearch(matrix, target, mid, hi);
        } else {
            return binarySearch(matrix, target, lo,mid);
        }
    }

    public int[] index2m(int index, int longth) {
        int[] result = new int[2];
        result[0] = (int) index / longth;
        result[1] = index % longth;
        return result;
    }
}
// @lc code=end

