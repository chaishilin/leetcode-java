import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        List<Node> stack = new ArrayList<>();
        Node result = new Node();
        result.next = head;
        while (head != null) {
            if (head.child != null) {
                //如果有孩子，则next指向的节点入栈
                if(head.next != null)
                    stack.add(head.next);
                //next指向child，child的前一个指向当前节点，当前节点的child指向null
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
            } else {
                if (head.next == null && stack.size() > 0) {
                    //如果当前列表走完了，则当前head指向栈中元素
                    Node popNode = stack.get(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    head.next = popNode;
                    popNode.prev = head;
                } else {
                    head = head.next;
                }
            }
        }
        /*
        Node tt = result.next;
        while (tt != null) {
            if(tt.prev != null && tt.next != null)
               System.out.println(tt.prev.val+"|"+tt.val+"|"+tt.next.val);
            tt = tt.next;
        }
        */
        /*
        Your runtime beats 100 % of java submissions
        Your memory usage beats 48.14 % of java submissions (36.5 MB)
        */
        return result.next;
    }
}
// @lc code=end

