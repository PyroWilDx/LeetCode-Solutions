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

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        isBalancedRec(root);
        return result;
    }

    public int isBalancedRec(TreeNode node) {
        if (!result || node == null)
            return 0;

        int leftDepth = isBalancedRec(node.left);
        int rightDepth = isBalancedRec(node.right);

        if (Math.abs(rightDepth - leftDepth) > 1) {
            result = false;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
