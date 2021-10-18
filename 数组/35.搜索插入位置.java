package 数组;
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
       return help(nums,0,nums.length-1, target);
    }

    public int help(int[] nums, int lo, int hi, int target) {
        if(lo  == hi){
            if(target <= nums[lo]){
                return lo;
            }else{
                return hi+1;
            }
        }else if(lo + 1 == hi){
            if(target <= nums[lo]){
                return lo;
            }else if(target > nums[hi]){
                return hi+1;
            }else{
                return hi;
            }
        }
        //二分，却容易出错
        int mid = (lo+hi)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return help(nums, lo,mid, target);
        }else{
            return help(nums, mid, hi, target);
        }
    }
}
// @lc code=end

