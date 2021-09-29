/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }
        int count = 0;
        while (queue.size() != 0) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> queue2 = new ArrayList<>();
            //[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21]

            while (queue.size() != 0) {
                root = queue.remove(queue.size() - 1);//交换left和right顺序即可
                temp.add(root.val);//每次pop最后一个

                if (count % 2 == 0) {
                    if (root.left != null) {
                        queue2.add(root.left);
                    }
                    if (root.right != null) {
                        queue2.add(root.right);
                    }
                } else {
                    if (root.right != null) {
                        queue2.add(root.right);
                    }
                    if (root.left != null) {
                        queue2.add(root.left);
                    }
                }
                
            }
            queue = queue2;
            result.add(temp);
            count += 1;
        }
        return result;

    }
}
// @lc code=end

