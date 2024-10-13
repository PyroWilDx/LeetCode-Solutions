import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int N = deque.size();
            Node prevNode = deque.removeFirst();
            addChildren(prevNode, deque);

            for (int i = 0; i < N - 1; i++) {
                Node currNode = deque.removeFirst();
                addChildren(currNode, deque);
                prevNode.next = currNode;
                prevNode = currNode;
            }
        }

        return root;
    }

    public void addChildren(Node node, Deque<Node> deque) {
        if (node.left != null) {
            deque.addLast(node.left);
            node.left.next = node.right;
        }
        if (node.right != null) {
            deque.addLast(node.right);
        }
    }
}
