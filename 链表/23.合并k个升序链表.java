package 链表;
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    //思路：优先级队列（堆）来维护各个链表头的大小
    class Status implements  Comparable<Status> {
        //搞个status类来套皮ListNode
        int val;
        ListNode node;

        Status(int val,ListNode node) {
            this.val = val;
            this.node = node;
        }
        public int compareTo(Status s){
            return this.val-s.val; 
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //用优先级队列存放每个lists的head
        PriorityQueue<Status> pq = new PriorityQueue<>();
        ListNode preHead = new ListNode(); //哨兵节点，比所有节点早一个
        ListNode result = preHead;//答案指向哨兵初始化节点的下一个
        for (int i = 0; i < lists.length; i++) {
            //初始化，首先添加进各个链表的头
            if (lists[i] != null) {
                pq.add(new Status(lists[i].val,lists[i]));
            }
        }
        while (!pq.isEmpty()) {
            //如果优先级队列不为空
            Status maxItem = pq.poll();//弹出当前最大的节点，接入prehead
            preHead.next = maxItem.node;
            preHead = preHead.next;
            ListNode nextItem = maxItem.node.next;//如果弹出的当前最大节点存在下一个值，则将该值存入优先级队列
            if (nextItem != null) {
                pq.add(new Status(nextItem.val,nextItem));
            }
        }
        return result.next;
        /*
        执行用时：11 ms , 在所有 Java 提交中击败了 31.53%的用户
        内存消耗：40.3 MB, 在所有 Java 提交中击败了25.26%的用户
        */
    }
}
// @lc code=end

