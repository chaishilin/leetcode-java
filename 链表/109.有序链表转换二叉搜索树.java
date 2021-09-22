/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        //思路：采用整体递归的思路。找到中间的叶子节点，接上左边和右边的节点。
        if (head == null) {
            //递归出口：无节点、一个节点、两个节点
            return null;
        } else if (head.next == null) {
            //一个节点
            TreeNode mid = new TreeNode();
            mid.val = head.val;
            return mid;
        } else if (head.next.next == null) {
            //两个节点
            TreeNode mid = new TreeNode();
            mid.val = head.next.val;
            TreeNode left = new TreeNode();
            left.val = head.val;
            mid.left = left;
            return mid;
        }
        ListNode slow = head;//快慢指针找中间
        ListNode fast = head;
        ListNode slowPre = new ListNode();
        slowPre.next = slow;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow为中点，注意这里要把中点前面的跟中点及以后的节点断掉
        slowPre.next = null;
        
        TreeNode mid = new TreeNode();
        mid.val = slow.val;
        mid.left = this.sortedListToBST(head);//递归调用
        mid.right = this.sortedListToBST(slow.next);

        return mid;
        /*
        Your runtime beats 35.9 % of java submissions
        Your memory usage beats 88.05 % of java submissions (39.3 MB)
        */



    }
}
// @lc code=end

