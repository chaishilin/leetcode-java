import org.graalvm.compiler.graph.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
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
    
    public void point(Node rootLeft, Node rootRight) {
        if (rootLeft == null || rootRight == null) {
            return;
        }
        rootLeft.next = rootRight;//左孩子指向右孩子
        //核心思路在于，next能指到的都指一下
        //该题目与[116]题的不同之处在于，116为完美二叉树，而该题的节点的左右孩子不一定齐全。
        //虽然该题的要求为：左子树的右边节点指向右子树的左边节点，然而，这样很容易出现漏指的情况。
        //比如：
        /*
                    1
                  /   \
                2       3
               / \       \
              4   5       6
             / \           \
            7   8           9
         */
        //很容易因为走到节点5后，误以为下面没有节点了，因此只连接了5->6,而没有连接8->9
        //因此，要反其道而性质，先把左子树的左孩子指向右子树的右孩子，先保证有得指
        //再逐渐更新，让满足要求的左子树的右孩子指向右子树的左孩子
        //因此，以下的if都没有else，因为都要进行操作。
        if (rootLeft.left != null) {
            if (rootRight.right != null) {
                point(rootLeft.left, rootRight.right);//左孩子的左孩子指向右孩子的右孩子
            }
            if (rootRight.left != null) {
                point(rootLeft.left, rootRight.left);//左孩子的左孩子指向右孩子的左孩子
            }
        }
        if (rootLeft.right != null) {
            if (rootRight.right != null) {
                point(rootLeft.right, rootRight.right);//左孩子的右孩子指向右孩子的右孩子
            }
            if (rootRight.left != null) {
                point(rootLeft.right, rootRight.left);//左孩子的右孩子指向右孩子的左孩子
            }
        } 
        
    }
    

}
// @lc code=end

