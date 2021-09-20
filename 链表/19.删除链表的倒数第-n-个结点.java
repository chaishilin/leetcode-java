/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //设置哨兵节点
        ListNode pre = new ListNode();
        pre.val = -1;
        pre.next = head;
        //哨兵节点一般就是在head前面
        int count = 0;
        ListNode countNode = head;
        while (countNode != null) {
            countNode = countNode.next;
            count += 1;
        }
        int m = count - n;//倒数第N个是正数第M个
        
        ListNode before = pre;
        for (int i = 0; i < m; i++) {
            //没轮到要删除节点的，继续往下找
            head = head.next;
            before = before.next;
        }
        //找到以后，前一个节点直接指向要删除节点的下一个~
        before.next = head.next;
        
        //永远返回的都是哨兵节点的下一个！
        return pre.next;

        /*
        运行结果：
        Your runtime beats 100 % of java submissions
        Your memory usage beats 37.59 % of java submissions (36.5 MB)
        */
    }    

}
// @lc code=end

