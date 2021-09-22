import java.util.concurrent.CountDownLatch;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count += 1;
        }
        int current = 0;
        ListNode[] result = new ListNode[k];
        //分为k组的关键在于确定每一组有多少个元素
        while (head != null && current < k) {
            temp = new ListNode();
            ListNode record = temp;//temp相当于哨兵，record相当于记录答案的listnode
           
            for (int i = 0; i < count / k; i++) {
                //count/k向下取整的个数
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
            if (current < count % k) {
                //如果是出现余数的前几个组,则继续添加一个
                temp.next = head;
                temp = temp.next;
                head = head.next;
            }
            //结束后断掉尾巴
            temp.next = null;//当前已经循环到了temp，完成一组，temp断掉指向下一个的指针
            result[current] = record.next;
            current += 1;//while中循环一共进行k次
        }
        return result;
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 8.62 % of java submissions (38.8 MB)
        */
    }
}
// @lc code=end

