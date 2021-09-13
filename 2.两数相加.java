/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //答案接在l1上
        ListNode preHead = new ListNode();
        ListNode tempTail1 = new ListNode();//这两个分别是l1和l2的前一个结点
        ListNode tempTail2 = new ListNode();
        preHead.next = l1;
        int flag = 0;
        while (l1 != null && l2 != null) {
            tempTail1 = l1;
            tempTail2 = l2;
            l1.val = flag + l1.val + l2.val;
            flag = 0;//加完后，flag置0
            if (l1.val >= 10) {
                flag = 1;
                l1.val = l1.val % 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {//如果l2比较长，则l1的最后一个结点的下一个指向l2
            tempTail1.next = l2;
            l1 = l2;//l2换个名字叫l1
        }
                
        while (l1 != null) {
            tempTail1 = l1;
            l1.val += flag;
            flag = 0;//加完后，flag置0
            if (l1.val >= 10) {
                flag = 1;
                l1.val = l1.val % 10;
            }
            l1 = l1.next;
        }
        if (flag == 1) {//如果还要进位
            ListNode temp = new ListNode();
            tempTail1.next = temp;//前一个的尾巴指向新的节点
            temp.val = 1;
        }
        return preHead.next;

    }
}
// @lc code=end

