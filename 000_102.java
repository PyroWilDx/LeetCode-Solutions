import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
 
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> lvlStack = new ArrayDeque<>();
        stack.add(root);
        lvlStack.add(0);
        int lastLvl = -1;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int lvl = lvlStack.pop();

            if (node.left != null) {
                stack.add(node.left);
                lvlStack.add(lvl + 1);
            }

            if (node.right != null) {
                stack.add(node.right);
                lvlStack.add(lvl + 1);
            }

            if (lastLvl != lvl) {
                result.add(new ArrayList<>());
            }
            result.get(lvl).add(node.val);

            lastLvl = lvl;
        }

        return result;
    }
}
