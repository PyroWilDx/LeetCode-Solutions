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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRec(p, q);
    }

    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }
}
