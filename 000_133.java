import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node result = new Node(node.val);

        Deque<Node> nodesToClone = new ArrayDeque<>();
        Map<Integer, Node> clonedNodes = new HashMap<>();
        nodesToClone.add(node);
        clonedNodes.put(result.val, result);
        while (!nodesToClone.isEmpty()) {
            Node currNode = nodesToClone.removeFirst();
            Node clonedNode = clonedNodes.get(currNode.val);
            for (Node neighbor : currNode.neighbors) {
                if (!clonedNodes.containsKey(neighbor.val)) {
                    nodesToClone.add(neighbor);
                }
                Node clonedNeighborNode = clonedNodes.get(neighbor.val);
                if (clonedNeighborNode == null) {
                    clonedNeighborNode = new Node(neighbor.val);
                    clonedNodes.put(neighbor.val, clonedNeighborNode);
                }
                clonedNode.neighbors.add(clonedNeighborNode);
            }
        }

        return result;
    }
}
