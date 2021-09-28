import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        help(root, targetSum);//help就写成一个简单的函数，功能是寻找以root为根节点的
        if (root != null) {
            //把逻辑稍微复杂一点的函数放在外面。
            pathSum(root.left, targetSum);//寻找root.left为根节点的
            pathSum(root.right, targetSum);//寻找root.right为根节点的
        }
        return count;
    }

    public void help(TreeNode root, int leftNum) {
        if (root != null && leftNum == root.val) {
            count += 1;
        } else if (root == null) {
            return;
        }
        help(root.left, leftNum - root.val);
        help(root.right, leftNum - root.val);
    }
}
// @lc code=end

