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

    private int result;
    private int cpt = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRec(root, k);
        return result;
    }

    public void kthSmallestRec(TreeNode node, int k) {
        if (node == null || cpt >= k)
            return;

        kthSmallestRec(node.left, k);

        cpt++;
        if (cpt == k) {
            result = node.val;
        }

        kthSmallestRec(node.right, k);
    }
}
