import java.lang.management.ThreadInfo;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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
    private Random r;
    private ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.r = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        //蓄水池抽样算法 k=1的情况
        ListNode cur = this.head;
        int result = cur.val;
        int count = 1;
        while (cur != null) {
            int randomNum = this.r.nextInt(count);
            //对于新加入的第k+1个数字，有1/(k+1)的几率成为被选择的数字。
            if (0 == randomNum) {
                result = cur.val;
            }
            //有k/(k+1)的几率不被选择
            count += 1;
            cur = cur.next;
        }
        return result;
    }
    /*
    推广：取海量数据中的随机k个数字
    对于前k个数字，全取。
    对于第m个数字，有k/m的几率选取，并且替换k中数字的任意一个
    有(m-k)/m的几率不被选择
    */
}

/**
* Your Solution object will be instantiated and called as such:
* Solution obj = new Solution(head);
* int param_1 = obj.getRandom();
*/
// @lc code=end

