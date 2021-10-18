import java.awt.List;
import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        while (stack.size() > 0) {
            //迭代前序遍历
            while (root != null && root.left != null) {
                //一直左节点入栈
                stack.add(root.left);
                root = root.left;
            }
            //展示根节点
            root = stack.get(stack.size() - 1);
            //System.out.println(root.val);//每次遍历
            if (k-- == 1) {
                //因为是二叉搜索树，第k大的数字就是遍历的第K个数字
                return root.val;
            }
            stack.remove(root);
            root = root.right;//右节点(如有)入栈
            if (root != null) {
                stack.add(root);
            }
        }
        return 1;
    }
}
// @lc code=end

