import java.util.ArrayList;
import java.util.List;

class BSTIterator {
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

    private List<Integer> values;
    private int i;

    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        i = 0;
        buildValues(root);
    }

    public void buildValues(TreeNode node) {
        if (node == null) {
            return;
        }

        buildValues(node.left);
        values.add(node.val);
        buildValues(node.right);
    }

    public int next() {
        return values.get(i++);
    }

    public boolean hasNext() {
        return i < values.size();
    }
}
