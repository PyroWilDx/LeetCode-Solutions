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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSumRec(root, 0, targetSum);
    }

    public boolean hasPathSumRec(TreeNode node, int currSum, int targetSum) {
        if (node == null) {
            return false;
        }

        currSum += node.val;
        if (node.left == null && node.right == null) {
            return currSum == targetSum;
        }

        return hasPathSumRec(node.left, currSum, targetSum)
                || hasPathSumRec(node.right, currSum, targetSum);
    }
}
