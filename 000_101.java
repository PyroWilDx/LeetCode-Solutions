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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricRec(root.left, root.right);
    }

    public boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }
}
