class Solution {
    int count = 1;
    TreeNode result = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        help(root, p);
        return result;
    }

    public void help(TreeNode root, TreeNode p) {
        if (root == null || count < 0) {
            return;
        }
        help(root.left, p);
        if (count == 0) {
            result = root;
            count -= 1;
            return;
        }
        if (root.val == p.val) {
            count = count - 1;
        }
        help(root.right, p);
    }
}