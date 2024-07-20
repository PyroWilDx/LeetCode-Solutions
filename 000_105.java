import java.util.HashMap;
import java.util.Map;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int[] preorder;
    Map<Integer, Integer> inorderIndices;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }

        return buildTreeRec(0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTreeRec(int pi, int pj, int ii, int ij) {
        if (pi >= pj) return null;

        TreeNode root = new TreeNode(this.preorder[pi]);

        int mid = inorderIndices.get(root.val);
        int length = mid - ii;
        
        root.left = buildTreeRec(pi + 1, pi + length + 1, ii, mid);
        root.right = buildTreeRec(pi + length + 1, pj, mid + 1, ij);

        return root;
    }
}
