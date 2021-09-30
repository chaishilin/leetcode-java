import jdk.internal.jimage.ImageReader.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        //进行一个普通的前序递归遍历
        point(root.left, root.right);//对于当前节点，要把自己的左右孩子紧密连接起来
        connect(root.left);
        connect(root.right);
        return root;
    }
    
    public void point(Node rootLeft,Node rootRight) {
        if (rootLeft == null || rootRight == null) {
            return;
        }
        rootLeft.next = rootRight;//左孩子指向右孩子
        point(rootLeft.right, rootRight.left);//左孩子的右孩子指向右孩子的左孩子
    }
}
// @lc code=end

