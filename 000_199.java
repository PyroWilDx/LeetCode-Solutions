import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewRec(root, 0, result);
        return result;
    }

    public void rightSideViewRec(TreeNode node, int d, List<Integer> result) {
        if (node == null) return;

        if (result.size() == d) result.add(node.val);
        else result.set(d, node.val);

        rightSideViewRec(node.left, d + 1, result);
        rightSideViewRec(node.right, d + 1, result);
    }
}
