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

    private boolean result = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isSubTreeRec(root, subRoot);
        return result;
    }

    public void isSubTreeRec(TreeNode node, TreeNode subRoot) {
        if (result || node == null)
            return;

        if (isSameTreeRec(node, subRoot))
            result = true;

        isSubTreeRec(node.left, subRoot);
        isSubTreeRec(node.right, subRoot);
    }

    public boolean isSameTreeRec(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;

        return isSameTreeRec(node1.left, node2.left) && isSameTreeRec(node1.right, node2.right);
    }
}
