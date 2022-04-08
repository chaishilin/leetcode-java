package 树;
/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>(); 
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while (!q.isEmpty()){
                Node node = q.poll();
                temp.add(node.val);
                if(node.children  != null){
                    q2.addAll(node.children);
                }
            }
            result.add(temp);
            Queue<Node> tq = q;
            q = q2;
            q2 = tq;
        }
        return result;
    }
}
// @lc code=end

