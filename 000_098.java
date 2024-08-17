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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRec(TreeNode node, long leftBound, long rightBound) {
        if (node == null)
            return true;

        if (node.val <= leftBound)
            return false;
        if (node.val >= rightBound)
            return false;

        return isValidBSTRec(node.left, leftBound, node.val)
                && isValidBSTRec(node.right, node.val, rightBound);
    }
}
