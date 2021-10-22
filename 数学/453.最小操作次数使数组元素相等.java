import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.jcp.xml.dsig.internal.dom.Utils;


/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        //n-1个数同时加一，就好比每次有一个数自身减1
        //所以最后数组的数字就是最小值
        //所以每个数字最后都要减到最小值
        int minNum = Arrays.stream(nums).min().getAsInt();
        int count = 0;
        for(int num:nums){
            count += num-minNum;
        }           
        return count;
    }
}
// @lc code=end

