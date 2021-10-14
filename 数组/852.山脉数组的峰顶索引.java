/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return help(arr, 0, arr.length - 1);
    }

    public int help(int[] arr, int lo, int hi) {
        //二分法:少于三个时，比大小获得下标
        if (arr.length <= 1) {
            return arr.length;
        }
        if(lo + 1 == hi){
            if(arr[lo] > arr[hi]){
                return lo;
            }else{
                return hi;
            }
        }
        //区间为[lo,hi]
        int mid = (lo + hi) / 2;
        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
            return mid;
        }else if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid+1]){
            return help(arr, mid, hi);
        }else{
            return help(arr, lo, mid);
        }
    }
}
// @lc code=end

