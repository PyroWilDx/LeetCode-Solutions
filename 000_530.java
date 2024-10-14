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

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifferenceRec(root);
        return result;
    }

    private int lastVal = Integer.MAX_VALUE;
    private int result = Integer.MAX_VALUE;

    public void getMinimumDifferenceRec(TreeNode node) {
        if (node == null) {
            return;
        }

        getMinimumDifferenceRec(node.left);

        int absDiff = Math.abs(node.val - lastVal);
        result = Math.min(result, absDiff);
        lastVal = node.val;

        getMinimumDifferenceRec(node.right);
    }
}
