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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = computeHeight(root);
        return countNodesRec(root, (1 << h) - 1, 1, h);
    }

    public int computeHeight(TreeNode node) {
        int h = 1;
        while (node.left != null) {
            node = node.left;
            h++;
        }
        return h;
    }

    public int countNodesRec(TreeNode node, int currVal, int currHeight, int h) {
        if (node == null) {
            return -1;
        }

        if (node.left == null && node.right == null) {
            if (currHeight != h) {
                return -1;
            }
            return currVal;
        }

        int rightValue = countNodesRec(node.right, currVal, currHeight + 1, h);
        if (rightValue == -1) {
            currVal -= 1 << (h - (currHeight + 1));
            int leftValue = countNodesRec(node.left, currVal, currHeight + 1, h);
            return leftValue;
        }
        return rightValue;
    }
}
