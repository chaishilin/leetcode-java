import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList();
        help(root, targetSum, path);
        return result;
    }
    
    public void help(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root != null && root.left == null && root.right == null && targetSum == root.val) {
            result.add(path);
            return;
        } 
        help(root.left, targetSum - root.val, new ArrayList<>(path));//两个都是不同的arrayList，都要new出来
        help(root.right, targetSum - root.val,new ArrayList<>(path));
        
      
    }
}
// @lc code=end

