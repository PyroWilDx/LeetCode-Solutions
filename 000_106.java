import java.util.HashMap;
import java.util.Map;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        int[] i = new int[1];
        i[0] = postorder.length - 1;
        return buildTreeRec(inorderIdxMap, postorder, 0, inorder.length - 1, i);
    }

    public TreeNode buildTreeRec(Map<Integer, Integer> inorderIdxMap, int[] postorder, int l, int r, int[] i) {
        if (l > r) {
            return null;
        }

        int val = postorder[i[0]];
        i[0]--;
        TreeNode node = new TreeNode(val);

        int inorderIdx = inorderIdxMap.get(node.val);
        node.right = buildTreeRec(inorderIdxMap, postorder, inorderIdx + 1, r, i);
        node.left = buildTreeRec(inorderIdxMap, postorder, l, inorderIdx - 1, i);

        return node;
    }
}
