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

    public int goodNodes(TreeNode root) {
        return goodNodesRec(root, Integer.MIN_VALUE);
    }

    public int goodNodesRec(TreeNode node, int max) {
        if (node == null)
            return 0;

        int val = 0;
        if (node.val >= max) {
            val++;
            max = node.val;
        }

        return val + goodNodesRec(node.left, max) + goodNodesRec(node.right, max);
    }
}
