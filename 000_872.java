import java.util.ArrayList;
import java.util.List;

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Values = new ArrayList<>();
        List<Integer> root2Values = new ArrayList<>();
        getLeafValues(root1, root1Values);
        getLeafValues(root2, root2Values);

        if (root1Values.size() != root2Values.size()) {
            return false;
        }

        for (int i = 0; i < root1Values.size(); i++) {
            int v1 = root1Values.get(i);
            int v2 = root2Values.get(i);
            if (v1 != v2) {
                return false;
            }
        }

        return true;
    }

    public void getLeafValues(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            values.add(node.val);
        }

        getLeafValues(node.left, values);
        getLeafValues(node.right, values);
    }
}
