import java.util.ArrayList;
import java.util.List;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import javax.swing.tree.TreeNode;

import org.graalvm.compiler.core.target.Backend;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode a = new TreeNode();
    TreeNode b = new TreeNode();
    TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode minNode = new TreeNode(Integer.MAX_VALUE);

    public void recoverTree(TreeNode root) {
        //该题目的本质在于，二叉搜索树的两个节点的位置不对，需要进行一次交换
        //二叉搜索树的特性在于，中序遍历后的结果为升序序列
        //而由于两个节点的位置不对，导致遍历后的结果序列中，存在逆序对。
        //因此，该题目成为了在一个结果序列中，寻找最大跨度的逆序对的问题。比如序列为[3,2,1],则最大跨度的逆序对为[3,1]
        //将找到的逆序对交换，就可以恢复二叉搜索树
        if (root == null) {
            return;
        }
        midPath(root);
        swap(a, b);
    }
    
    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void midPath(TreeNode root) {
        if (root == null) {
            return;
        }
        midPath(root.left);//中旬遍历，查找结果序列
        if(root.val > maxNode.val){
            maxNode = root;//遍历过程中，更新迄今为止的最大值，并对于每个新的最大值，初始化对应的最小值
            minNode = root;
        } else if (root.val < minNode.val) {
            minNode = root;//对于之前出现过的最大值，如果当前值小于其最大值，说明为逆序对
        }        
        if (maxNode != minNode) {
            a = maxNode;//更新出现的每个逆序对，越往后遍历，逆序对跨度越长。
            b = minNode;
        }  
        midPath(root.right);
        return;
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 29.05 % of java submissions (38.9 MB)
        */
    }  
}
// @lc code=end

