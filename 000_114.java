class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev = null;

    public void flatten(TreeNode node) {
        if (node == null) {
            return;
        }

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
