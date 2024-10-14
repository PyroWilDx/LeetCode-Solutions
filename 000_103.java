import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        boolean leftToRight = true;
        while (!deque.isEmpty()) {
            int n = deque.size();
            Deque<TreeNode> nextChildren = new ArrayDeque<>();
            List<Integer> currTraversalList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node;
                if (leftToRight) {
                    node = deque.removeFirst();
                } else {
                    node = deque.removeLast();
                }
                currTraversalList.add(node.val);
                if (leftToRight) {
                    addLeftChild(node, leftToRight, nextChildren);
                    addRightChild(node, leftToRight, nextChildren);
                } else {
                    addRightChild(node, leftToRight, nextChildren);
                    addLeftChild(node, leftToRight, nextChildren);
                }
            }
            deque.addAll(nextChildren);
            result.add(currTraversalList);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public void addLeftChild(TreeNode node, boolean leftToRight, Deque<TreeNode> nextChildren) {
        if (node.left != null) {
            if (leftToRight)
                nextChildren.addLast(node.left);
            else
                nextChildren.addFirst(node.left);
        }
    }

    public void addRightChild(TreeNode node, boolean leftToRight, Deque<TreeNode> nextChildren) {
        if (node.right != null) {
            if (leftToRight)
                nextChildren.addLast(node.right);
            else
                nextChildren.addFirst(node.right);
        }
    }
}
