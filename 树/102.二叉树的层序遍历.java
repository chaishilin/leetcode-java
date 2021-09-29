import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.graalvm.compiler.nodes.graphbuilderconf.IntrinsicContext;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }
        
        while (queue.size() != 0) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> queue2 = new ArrayList<>();
            while (queue.size() != 0) {
                root = queue.remove(0);
                temp.add(root.val);
                if (root.left != null) {
                    queue2.add(root.left);
                }
                if (root.right != null) {
                    queue2.add(root.right);
                }
            }
            queue = queue2;
            result.add(temp);
        }
        return result;
    }
}
// @lc code=end

