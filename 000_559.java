import java.util.List;

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        return maxDepthRec(root, 1);
    }

    public int maxDepthRec(Node node, int currDepth) {
        if (node.children == null || node.children.isEmpty()) {
            return currDepth;
        }

        int result = -1;
        for (Node child : node.children) {
            int depth = maxDepthRec(child, currDepth + 1);
            if (depth > result) {
                result = depth;
            }
        }
        return result;
    }
}
