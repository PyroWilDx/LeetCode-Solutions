class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode lowestCommonAncestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorRec(root, p, q);
        return lowestCommonAncestor;
    }

    public boolean[] lowestCommonAncestorRec(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new boolean[] { false, false };
        }

        boolean[] leftResult = lowestCommonAncestorRec(node.left, p, q);
        boolean[] rightResult = lowestCommonAncestorRec(node.right, p, q);

        if (lowestCommonAncestor != null) {
            return null;
        }

        boolean[] result = new boolean[] {
                leftResult[0] || rightResult[0],
                leftResult[1] || rightResult[1]
        };

        if (node.val == p.val) {
            result[0] = true;
        } else if (node.val == q.val) {
            result[1] = true;
        }

        if (result[0] && result[1]) {
            lowestCommonAncestor = node;
            return null;
        }

        return result;
    }
}
