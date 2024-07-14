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

    private int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeRec(root);
        return maxDepth;
    }

    public int diameterOfBinaryTreeRec(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = diameterOfBinaryTreeRec(node.left);
        int rightDepth = diameterOfBinaryTreeRec(node.right);

        maxDepth = Math.max(maxDepth, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
