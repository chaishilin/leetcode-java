import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = buildNums2(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = m.get(nums1[i]);
        }
        return result;
    }

    public Map<Integer, Integer> buildNums2(int[] nums2) {
        //建立单调递减栈，从nums2反向遍历
        /***
         * 单调栈很适合用于求数字的下一个最大数字，两个最大数字之间的区间等类似问题
         * Your runtime beats 91.45 % of java submissions
         * Your memory usage beats 74.36 % of java submissions (38.5 MB)
         */
        List<Integer> stack = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            //System.out.println(stack.toString());
            while (stack.size() > 0 && stack.get(stack.size() - 1) < nums2[i]) {
                stack.remove(stack.size() - 1);//如果当前元素大于栈顶元素，则移出栈顶元素
            }
            if (stack.size() == 0) {
                m.put(nums2[i], -1);//如果单调栈中为空，则当前数字后面没有更大的数字了。
            } else {
                //单调栈中的栈顶元素就是比当前数字大的下一个数字
                m.put(nums2[i], stack.get(stack.size() - 1));
            }
            stack.add(nums2[i]);//当前数字入栈
        }
        //System.out.println(m.toString());
        return m;
    }
}
// @lc code=end

