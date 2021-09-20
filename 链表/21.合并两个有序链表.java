/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();//result节点用于一路按照升序走下去，穿针引线。
        ListNode preResult = result;//preResult节点用于返回result的起点，即结果
        result.val = -1;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //l1比较小
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null) {
            result.next = l1;
            l1 = l1.next;
        } else if(l2 != null){
            result.next = l2;
            l2 = l2.next;
        }
        return preResult.next;
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 76.95 % of java submissions (37.7 MB)
        */
    }
}
// @lc code=end

