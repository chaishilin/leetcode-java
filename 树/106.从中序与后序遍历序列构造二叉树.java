import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.tree.TreeNode;

import org.graalvm.compiler.graph.InlineCacheGuardPosition;

import jdk.internal.org.jline.terminal.impl.PosixSysTerminal;
import jdk.nashorn.internal.runtime.arrays.IntElements;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());//int[] 转arrayList咋这么麻烦
        List<Integer> postList = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return builTreeHelp(inList, postList);
        
    }

    public TreeNode builTreeHelp(List<Integer> inList, List<Integer> postList) {
        if (inList.size() == 0) {
            return null;
        }
        if (inList.size() == 1) {
            return new TreeNode(inList.get(0));
        }
        
        TreeNode root = new TreeNode(postList.get(postList.size() - 1));
        int index = inList.indexOf(root.val);
        List<Integer> newInListLeft = inList.subList(0, index);
        List<Integer> newInListRight = inList.subList(index + 1, inList.size());
        List<Integer> newPostListLeft = postList.subList(0, index);//经过观察发现，中序根节点的左子树在中序遍历的前面，恰好也是在后序遍历的前面，个数相同。因此可以递归。
        List<Integer> newPostListRight = postList.subList(index,postList.size()-1);
        root.left = builTreeHelp(newInListLeft, newPostListLeft);
        root.right = builTreeHelp(newInListRight, newPostListRight);
        return root;
    }
}
// @lc code=end

