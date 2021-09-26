import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Twitter.ListNode;
import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
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
    public ListNode removeZeroSumSublists(ListNode head) {
        //学习的大佬解法：
        ListNode result = new ListNode();
        result.next = head;

        Map<Integer,ListNode> lMap = new HashMap<>();
        int sum = 0;
        for (ListNode temp = result; temp != null; temp = temp.next) {
            //首先循环一次，map中节点对应的值为累积和
            sum += temp.val;
            lMap.put(sum, temp);//如果遇到走到两个节点处发现累积和相同的，就更新为靠后的那个节点
        }
        
        //第二次循环，查看两个节点处累积和相同的情况，并且删掉这两个节点中的所有节点
        sum = 0;
        for (ListNode temp = result; temp != null; temp = temp.next) {
            sum += temp.val;
            temp.next = lMap.get(sum).next;
        }
        return result.next;

    }
}
// @lc code=end

