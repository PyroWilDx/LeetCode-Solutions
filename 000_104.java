class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return maxDepthRec(root, 0);
    }

    public int maxDepthRec(TreeNode node, int d) {
        if (node == null) {
            return d;
        }

        int leftDepth = maxDepthRec(node.left, d + 1);
        int rightDepth = maxDepthRec(node.right, d + 1);

        return Math.max(leftDepth, rightDepth);
    }
}
