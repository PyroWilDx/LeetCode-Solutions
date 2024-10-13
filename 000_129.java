import java.util.Stack;

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

    public int sumNumbers(TreeNode root) {
        return sumNumbersRec(root, new Stack<>());
    }

    public int sumNumbersRec(TreeNode node, Stack<Integer> digits) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            int sum = node.val;
            int mul = 10;
            for (int i = digits.size() - 1; i >= 0; i--) {
                sum += digits.get(i) * mul;
                mul *= 10;
            }
            return sum;
        }

        digits.add(node.val);
        int sum = sumNumbersRec(node.left, digits) + sumNumbersRec(node.right, digits);
        digits.pop();
        return sum;
    }
}
