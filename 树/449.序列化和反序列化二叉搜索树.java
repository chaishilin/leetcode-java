/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return root != null ? forward(root) : "";
    }

    // 二叉搜索树因为它本身是有顺序的，左边的比中间的小，右边的比中间的大
    // 因此只需要前序或者后序遍历即可
    private String forward(TreeNode root) {
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        result.append(",");
        if (root.left != null) {
            result.append(forward(root.left));
        }
        if (root.right != null) {
            result.append(forward(root.right));
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        List<Integer> forwardList = new ArrayList<>();
        for (String item : data.split(",")) {
            forwardList.add(Integer.parseInt(item));
        }
        return rebuild(forwardList, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // 恢复的时候，比如说是前序遍历，从前往后，遇到的比根节点小的，都属于左子树，其余的都是右子树。
    private TreeNode rebuild(List<Integer> forwardList, Integer lo, Integer hi) {
        if (forwardList.size() == 0 || forwardList.get(0) > hi || forwardList.get(0) < lo) {
            return null;
        }
        Integer rootValue = forwardList.remove(0);
        TreeNode root = new TreeNode(rootValue);
        root.left = rebuild(forwardList, lo, rootValue);
        root.right = rebuild(forwardList, rootValue, hi);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
