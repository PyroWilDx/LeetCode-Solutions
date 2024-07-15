class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) return lowestCommonAncestorRec(root, p, q);
        return lowestCommonAncestorRec(root, q, p);
    }

    public TreeNode lowestCommonAncestorRec(TreeNode node, TreeNode p, TreeNode q) {
        if (p.val < node.val && q.val > node.val) return node;
        if (p.val == node.val || q.val == node.val) return node;

        if (p.val < node.val) return lowestCommonAncestorRec(node.left, p, q);
        return lowestCommonAncestorRec(node.right, p, q);
    }
}
