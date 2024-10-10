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

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGstRec(root, 0);
        return root;
    }

    public int bstToGstRec(TreeNode node, int value) {
        if (node.left == null && node.right == null) {
            node.val += value;
            return node.val;
        }

        int rightValue = -1;
        if (node.right != null) {
            rightValue = bstToGstRec(node.right, value);
        }

        node.val += rightValue != -1 ? rightValue : value;

        int leftValue = -1;
        if (node.left != null) {
            leftValue = bstToGstRec(node.left, node.val);
        }

        return leftValue != -1 ? leftValue : node.val;
    }
}
